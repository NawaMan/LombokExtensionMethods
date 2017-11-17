package nawaman.lombok.extensionmethods;

import java.util.function.Supplier;

import lombok.experimental.ExtensionMethod;

@ExtensionMethod({ MainLambda.class })
public class MainLambda {
  public static <T> T orElse(T obj, Supplier<T> defSupplier) {
      return (obj != null) ? obj : defSupplier.get();
  }
  public static Supplier<String> S(Supplier<String> defSupplier) {
      return defSupplier;
  }
  public static void println(Object o) { System.out.println(o); }
  public static void main(String ... args) {
    String str = null;
    println(str.orElse((Supplier<String>)(()->("4"+"2"))));   // Nasty cast
    println(str.orElse(S(()->("4" + "2"))));                  // A bit less nasty
    // Use the one above if you badly need closure
    // Otherwwise, avoid it like plague.

    Supplier<String> nullString = ()-> "4" + "2"; 
    println(str.orElse(nullString));                          // A bit less nasty
    // Acceptable? Arguably.
  }
}