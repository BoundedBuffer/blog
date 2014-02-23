/**
 * Created by Rob Austin
 */
public class DoubleErrorStateEncoding {

// is 111111111111000000000000000000000000000000000000000000000000000 as binary
final static long DEFAULT_NAN = Double.doubleToRawLongBits(Double.NaN);

enum ErrorState {

    NAN_STATE_1, NAN_STATE_2;

    private final double value;

    ErrorState() {
        this.value = Double.longBitsToDouble(DEFAULT_NAN + ordinal());
    }

    /**
     * @return gets and encoded double based on this enum
     */
    public double toDouble() {
        return value;
    }

    /**
     * gets the ErrorState from double which must have been created by calling the {@code toDouble()}
     *
     * @param nan a double that has been created from
     * @return and ErrorState which represents this double
     */
    public static ErrorState valueOf(double nan) {
        final long ordinal = Double.doubleToRawLongBits(nan)  ^ (DEFAULT_NAN);
        return ErrorState.values()[(int) ordinal];

    }
}


public static void main(String args[]) {

    final double errorState1 = ErrorState.NAN_STATE_1.toDouble();
    System.out.println(Double.isNaN(errorState1));  //true

    final double errorState2 = ErrorState.NAN_STATE_2.toDouble();
    System.out.println(Double.isNaN(errorState2));  //true

    System.out.println(ErrorState.valueOf(errorState1));  // NAN_STATE_1
    System.out.println(ErrorState.valueOf(errorState2));  // NAN_STATE_2

}

}
