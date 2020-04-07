package basic;

import java.io.Serializable;

public class LoginBean implements Serializable {
private static final long serialVersionUID = 1L;

private String userid;
private String passwd;

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public String toString() { return userid + ", " +passwd;}


}
