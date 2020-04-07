package util;

import java.text.DecimalFormat;

public class FormatUtil {
	public static String number(long number,String pattern) {
		DecimalFormat format = new DecimalFormat();
		
		return format.format(number);
	}
}
