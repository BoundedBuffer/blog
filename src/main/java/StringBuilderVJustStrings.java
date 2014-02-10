/**
 * Created by Rob Austin
 */
public class StringBuilderVJustStrings {

    public void s1(int value) {

        String result =  "helllo, its "+value+" world";
        System.out.print(result);
    }

    public static void main() {
         new StringBuilderVJustStrings().s1( 1);
    }
}
