package member.service;

import java.util.Map;

public class JoinRequest {//회원가입시 필요한 데이터를 담고 폼에 입력한 값을 이 객체에 담아 JoinService에 전달
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isPasswordEqualToConfirm() { //password필드와 confirmPassword 필드 값이 같은지 검사
		return password!=null&password.equals(confirmPassword);
	}
	
	//각 필드의 데이터가 유효한지 검사.
	//파라미터로 전달받는 errors 맵 객체는 에러 정보를 담기위해 사용함.
	//id 필드값이 올바르지 않는 경우 errors맵 객체에 "id"키의 값으로 TRUE값을 추가함->JoinHandler에 생성하서 전달함
	public void validate(Map<String, Boolean>errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
		
	}
	
	
	//value가 값이 없는 경우 errors 맵 객체의 fieldName키에 TRUE를 값으로 추가한다.
	private void checkEmpty(Map<String , Boolean> errors, String value, String fieldName) {
		if(value==null||value.isEmpty())
		errors.put(fieldName, Boolean.TRUE);
	}
}
