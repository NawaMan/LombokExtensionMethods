package nawaman.lombok.extensionmethods;

import java.util.Optional;

import lombok.experimental.ExtensionMethod;

class Extensions {
    public static boolean isAllCap(String orgString) {
        return !orgString.matches(".*[a-z].*");
    }
    public static <T> T or(T obj, T defValue) {
        return (obj != null) ? obj : defValue;
    }
    
    public static boolean isNull(Object obj) {
        return (obj == null) || String.valueOf(obj).equals("null");
    }
    
    public static <T> Optional<T> or(T obj) {
        return Optional.ofNullable(obj);
    }
}

@ExtensionMethod({ Extensions.class })
public class MainFirst {
    public static void main(String[] args) {
        System.out.println("ONE".isAllCap());   // true
        System.out.println("TWO".isAllCap());   // false
    }
    
}
