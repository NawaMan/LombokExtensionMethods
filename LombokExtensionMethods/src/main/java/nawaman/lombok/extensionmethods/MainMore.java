package nawaman.lombok.extensionmethods;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.experimental.ExtensionMethod;

@ExtensionMethod({ MoreExtensions.class })
public class MainMore {
    public static void main(String[] args) {
        BigDecimal cost = "123.4567".toDecimal();
        LocalDate  date = "20171113".toLocalDate();
        System.out.println(cost);   // prints "123.46" 
        System.out.println(date);   // prints "2017-11-13"
        System.out.println("123.4567".toDecimal().compare("123.00".toDecimal()));   // prints 46
    }
}
