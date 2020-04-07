package di1.spring.xml2;
// 비만도 측정
public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	//비만도 측정
	public void bmiCalculator(double weight,double height) {
		double h = height*0.01;
		double result = weight/(h*h);
		System.out.println("BMI 지수 : "+(int) result);
		
		if(result>obesity) {
			System.out.println("비만입니다.");
		}else if(result > overWeight) {
			System.out.println("과 체중입니다.");
		}else if(result > normal) {
			System.out.println("정상 체중입니다.");
		}else {
			System.out.println("저 체중입니다.");
		}
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}
