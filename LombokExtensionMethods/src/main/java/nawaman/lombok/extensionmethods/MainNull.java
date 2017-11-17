package nawaman.lombok.extensionmethods;

import java.util.Optional;

import lombok.experimental.ExtensionMethod;

@ExtensionMethod({ MainNull.class })
public class MainNull {
  public static  <T> T or(T obj, T defValue) {
      return (obj != null) ? obj : defValue;
  }
  public static boolean isNull(Object obj) {
      return (obj == null) || String.valueOf(obj).equals("null");
  }
  public static <T> Optional<T> whenNotNull(T obj) {
      return Optional.ofNullable(obj);
  }
  public static void main(String ... args) {
    String str = null;
    System.out.println(str.or(""));   // prints ""
    System.out.println(str.isNull()); // prints true
    System.out.println(str.whenNotNull().map(String::length).orElse(0));  // prints 0
  }
}