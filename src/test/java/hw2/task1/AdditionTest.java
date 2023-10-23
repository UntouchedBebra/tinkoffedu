package hw2.task1;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdditionTest {
    @Test
    @DisplayName("Возврат суммы 1 и 2")
    void testConstant() {
        // given
        Expression additionOfOneAndTwoAsExpression = new Addition(new Constant(1), new Constant(2));
        // when
        double additionOfOneAndTwoAsPrimitive = additionOfOneAndTwoAsExpression.evaluate();
        // then
        Assertions.assertEquals(3, additionOfOneAndTwoAsPrimitive);
    }
}
