package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//root-context.xml 방식을 대신
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"org.zerock.controller","org.zerock.sample"})
@MapperScan(basePackages = "org.zerock.mapper")
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
//		<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		HikariConfig hc = new HikariConfig();
//		hc.setDriverClassName("oracle.jdbc.OracleDriver");
//		hc.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		
//		log4jdbc 설정한 경우
		hc.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hc.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:orcl");
		hc.setUsername("spring_db");
		hc.setPassword("spring_db");
	
		HikariDataSource hs = new HikariDataSource(hc);
			
		return hs;
		
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
//		<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
//		    <property name="dataSource" ref="dataSource"></property>
//	    </bean>
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(dataSource());
		return (SqlSessionFactory)sf.getObject();
		
	}

}


















