package di1.spring.xml;

public class MyCalculator {

	Calculator c;
	private int firstName;
	private int secondName;
	
	public MyCalculator() {
		
	}
	
	public void add() {
		c.addition(firstName, secondName);
	}
	public void sub() {
		c.subtraction(firstName, secondName);
	}
	public void mul() {
		c.multiplication(firstName, secondName);
	}
	public void div() {
		c.division(firstName, secondName);
	}

	public Calculator getC() {
		return c;
	}

	public void setC(Calculator c) {
		this.c = c;
	}

	public int getFirstName() {
		return firstName;
	}

	public void setFirstName(int firstName) {
		this.firstName = firstName;
	}

	public int getSecondName() {
		return secondName;
	}

	public void setSecondName(int secondName) {
		this.secondName = secondName;
	}
	
	
	
	
}
