import java.util.Calendar;

public class CurrentTime_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int M = c.get(Calendar.MONTH);
		int d = c.get(Calendar.DATE);
		int h = c.get(Calendar.HOUR_OF_DAY);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);

		System.out.println(y + "��" + M + "��" + d + "��" + h + "��" + m + "��" + s + "�� �Դϴ�.");

	}

}
