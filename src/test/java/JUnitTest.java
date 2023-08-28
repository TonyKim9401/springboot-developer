import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {

    @DisplayName("1 + 2는 3이다")
    @Test
    void junitTest() {
        // given
        int a = 1;
        int b = 2;
        // when
        int sum = 3;
        // then
        Assertions.assertEquals(a + b, sum);
        assertThat(sum).isEqualTo(a + b);
    }
/*
    @DisplayName("1 + 2는 4이다")
    @Test
    void junitFailedTest() {
        // given
        int a = 1;
        int b = 3;
        // when
        int sum = 3;
        // then
        Assertions.assertEquals(a + b, sum);
//        assertThat(sum).isEqualTo(a + b);
    }
*/

}
