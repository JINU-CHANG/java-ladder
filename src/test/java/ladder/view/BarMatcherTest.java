package ladder.view;

import ladder.domain.BarTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BarMatcherTest {

    @Test
    @DisplayName("valueOfBarMatcher()는 true값이 들어왔을때 -----값을 가진 enum이 반환된다.")
    void test_1() {
        // given & when
        BarMatcher trueBarMatcher = BarMatcher.valueOfBarMatcher(BarTest.TRUE);

        // then
        Assertions.assertThat(trueBarMatcher.getBarDisplay()).isEqualTo("-----");
    }

    @Test
    @DisplayName("valueOfBarMatcher()는 false값이 들어왔을때 스페이스 5개의 값을 가진 enum이 반환된다.")
    void test_2() {
        // given & when
        BarMatcher falseBarMatcher = BarMatcher.valueOfBarMatcher(BarTest.FALSE);

        // then
        Assertions.assertThat(falseBarMatcher.getBarDisplay()).isEqualTo("     ");
    }
}