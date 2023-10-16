package hw2.task1;

import edu.hw2.task1.Constant;
import edu.hw2.task1.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConstantTest {
    @Test
    @DisplayName("Возврат константы")
    void testConstant() {
        // given
        Expression positiveTenAsExpression = new Constant(10);
        // when
        double positiveTenAsPrimitive = positiveTenAsExpression.evaluate();
        // then
        Assertions.assertEquals(10, positiveTenAsPrimitive);
    }

}
