package laddergame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {


    @DisplayName("이름은 중복될 수 없다.")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> new Names(List.of("zeze", "zeze")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복 될 수 없습니다.");
    }
}