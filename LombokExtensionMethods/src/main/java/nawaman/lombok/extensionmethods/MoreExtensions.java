package nawaman.lombok.extensionmethods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

import lombok.val;

public class MoreExtensions {
	
	public static final BigDecimal _100 = new BigDecimal("100");
	
	public static boolean isZero(BigDecimal num) {
		return compare(num, BigDecimal.ZERO) == 0;
	}
	
	public static boolean equalTo(BigDecimal num1, BigDecimal num2) {
		return compare(num1, num2) == 0;
	}
	
	public static boolean equalTo(BigDecimal num1, String num2) {
		return equalTo(num1, new BigDecimal(num2));
	}
	
	public static int compare(BigDecimal num1, BigDecimal num2) {
		if (num1 == null)
			return Integer.MIN_VALUE;
		if (num2 == null)
			return Integer.MAX_VALUE;
		
		return num1.subtract(num2).multiply(_100).intValue();
	}
	
    public static BigDecimal toDecimal(String str) {
        if ((str == null)
         || "null".equals(str))
            return null;
        
        return new BigDecimal(str).setScale(2, RoundingMode.HALF_DOWN);
    }
	
    public static LocalDate toLocalDate(String str) {
        if ((str == null)
         || "null".equals(str)
         || "00000000".equals(str))
            return null;
        
        val format = str.contains("-") ? DateTimeFormatter.ISO_DATE : DateTimeFormatter.BASIC_ISO_DATE;
        return LocalDate.parse(str, format);
    }
	
	public static <T> Predicate<T> not(Predicate<T> check) {
		return t->!check.test(t);
	}

}
