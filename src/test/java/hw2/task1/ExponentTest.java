package hw2.task1;

import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Expression;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExponentTest {
    @Test @DisplayName("Возврат экспоненциирования 2 в -4 степень") void testConstant() {
        // given
        Expression exponentiationOfTwoToThePowerOfMinusFourAsExpression =
            new Exponent(new Constant(2), new Negate(new Constant(4)).evaluate());
        // when
        double exponentiationOfTwoToThePowerOfMinusFourAsPrimitive =
            exponentiationOfTwoToThePowerOfMinusFourAsExpression.evaluate();
        // then
        Assertions.assertEquals(Math.pow(2, -4), exponentiationOfTwoToThePowerOfMinusFourAsPrimitive);
    }
}
