package di1.spring.xml4;


public class StudentInfo {
	private Student s;
	
	
	
	//생성자를 통한 주입
	public StudentInfo(Student s) {
	
		this.s =s ;
		
	}
	public void getStudentInfo() {
		if(s!=null) {
			System.out.println("이름 : "+s.getName());
			System.out.println("나이 : "+s.getAge());
			System.out.println("학년 : "+s.getGradeName());
			System.out.println("반 : "+s.getClassNum());
			System.out.println("---------------------");
		}
	}
	public void setS(Student s) {
		this.s = s;
	}
}
