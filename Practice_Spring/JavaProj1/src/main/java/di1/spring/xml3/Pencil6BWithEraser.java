package di1.spring.xml3;

public class Pencil6BWithEraser extends Pencil6B implements Pencil{

	@Override
	public void use() {
		System.out.println("6B 굵기로 쓰이고, 지우개가 있습니다.");
	}
}
