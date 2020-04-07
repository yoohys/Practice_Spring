package auth.service;

public class User { //인증성공한 사용자의 정보 담기 (이 객체를 세션에 저장함)
	private String id;
	private String name;
	
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
