/**
 * Created by Rob Austin
 */
public class StringBuilderVJustStrings {

public static void main() {
    new StringBuilderVJustStrings().viaStringConcat(1);
    new StringBuilderVJustStrings().vaiStringBuilder(1);
}

public void viaStringConcat(int value) {
    String result = "helllo, its " + value + " world";
    System.out.print(result);
}

public void vaiStringBuilder(int value) {
    String result = new StringBuffer("hello, its ").append(value).append(" world").toString();
    System.out.print(result);
}

}
