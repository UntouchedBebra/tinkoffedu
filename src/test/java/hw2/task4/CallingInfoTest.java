package hw2.task4;

import edu.hw2.task4.CallingInfo;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallingInfoTest {

    @Test
    @DisplayName("Отображение имени тестового-класса и имени функции теста") public void testCallingInfo() {
        // given
        String expectedClassName = this.getClass().getName();

        Method testMethod = null;
        try {
            testMethod = CallingInfoTest.class.getMethod("testCallingInfo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        String expectedMethodName = testMethod.getName();

        // when
        CallingInfo result = CallingInfo.callingInfo();

        // then
        assertAll(
            () -> assertEquals(expectedClassName, result.className()),
            () -> assertEquals(expectedMethodName, result.methodName())
        );
    }
}
