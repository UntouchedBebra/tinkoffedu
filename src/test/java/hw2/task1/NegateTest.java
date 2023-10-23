package hw2.task1;

import edu.hw2.task1.Constant;
import edu.hw2.task1.Expression;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NegateTest {
    @Test
    @DisplayName("Возврат противоположной константы")
    void testConstant() {
        // given
        Expression negativeTenAsExpression = new Negate(new Constant(10));
        // when
        double positiveTenAsPrimitive = negativeTenAsExpression.evaluate();
        // then
        Assertions.assertEquals(-10, positiveTenAsPrimitive);
    }
}
