import java.util.function.DoubleBinaryOperator;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

/**
 * Created by Acer on 10/05/2017.
 */


public enum Operation {
    ADDITION((x, y) -> x+y), // algoritma tambah
    SUBTRACTION((x, y) -> x-y), // algoritma pengurangan
    DIVISION((x, y) -> x/y), // algoritma pembagian
    MULTIPLICATION((x, y) -> x*y), // algoritma perkalian
    PERCENTAGE((x, y) -> x%y), // algoritma persen
    PANGKAT((x,y) -> pow(x,y)), // algoritma pangkat
    AKAR((x,y) -> y=sqrt(x)); // algoritma akar

    private DoubleBinaryOperator operator;

    Operation(DoubleBinaryOperator operator) {
        this.operator = operator;
    }

    public DoubleBinaryOperator getOperator() {
        return operator;
    }
}
