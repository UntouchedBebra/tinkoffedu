package hw2.task2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LiskovSubstitutionPrincipleProblemTest {
    static Arguments[] rectangles() {
        return new Arguments[] {Arguments.of(new Rectangle(0, 0)), Arguments.of(new Square(0))};
    }

    @ParameterizedTest @MethodSource("rectangles") void rectangleArea(Rectangle rect) {
        assertThat(rect.setWidth(20).setHeight(10).area()).isEqualTo(200.0);
    }
}
