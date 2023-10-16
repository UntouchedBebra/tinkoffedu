package hw2.task1;

import edu.hw2.task1.Constant;
import edu.hw2.task1.Expression;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {
    @Test
    @DisplayName("Возврат произведения 10 и -20")
    void testConstant() {
        // given
        Expression multiplicationOfVariousExpressionsAsExpression = new Multiplication(
            new Constant(10),
            new Negate(new Constant(20))
        );
        // when
        double multiplicationOfVariousExpressionsAsPrimitive =
            multiplicationOfVariousExpressionsAsExpression.evaluate();
        // then
        Assertions.assertEquals(-200, multiplicationOfVariousExpressionsAsPrimitive);
    }
}
