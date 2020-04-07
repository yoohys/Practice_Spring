package di1.spring.xml4;

public class Student {
	private String name;
	private int age;
	private String gradeName;
	private String classNum;
	
	public Student(String name, int age, String gradeName, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeName = gradeName;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
	
}
