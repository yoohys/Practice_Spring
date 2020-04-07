package jdbc;

import java.io.StringReader;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;



public class DBCPInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig=sce.getServletContext().getInitParameter("poolConfig");
		Properties prop=new Properties();
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException("config load fail",e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);		
	}
	
	private void loadJDBCDriver(Properties prop) {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException ex){
			throw new RuntimeException("fail to load JDBC Driver",ex);
		}
	}
	
	private void initConnectionPool(Properties prop) {
		try {
			String jdbcUrl= "jdbc:oracle:thin:@localhost:1521:orcl";
			String username="board";
			String pw="board";
			//String jdbcUrl=prop.getProperty("jdbcUrl")+"&serverTimezone=UTC";
			//String username=prop.getProperty("dbUser");
			//String pw=prop.getProperty("dbPass");
			
			ConnectionFactory connFactory=new DriverManagerConnectionFactory(jdbcUrl,username,pw);
			
			PoolableConnectionFactory poolableconnFactory=new PoolableConnectionFactory(connFactory,null);
			
			String validationQuery=prop.getProperty("validationQuery");
			if(validationQuery!=null&&!validationQuery.isEmpty()) {
				poolableconnFactory.setValidationQuery(validationQuery);
			}
			GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			int minIdle=getIntProperty(prop, "minIdle", 5);
			poolConfig.setMaxTotal(minIdle);
			
			int maxTotal=getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);
			
			GenericObjectPool<PoolableConnection> connectionPool=new GenericObjectPool<>(poolableconnFactory,poolConfig);
			poolableconnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver=(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("board", connectionPool);
			
			//Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			//PoolingDriver driver=(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			//String poolName=prop.getProperty("poolName");
			//driver.registerPool(poolName, connectionPool);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	private int getIntProperty(Properties prop, String propName, int defaultValue) {
		String value=prop.getProperty(propName);
		if(value==null) return defaultValue;
		return Integer.parseInt(value);
	}
	
}
