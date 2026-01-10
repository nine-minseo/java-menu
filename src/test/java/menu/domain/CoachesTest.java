package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    void 코치가_2명_미만이면_예외가_발생한다() {
        // given
        List<Coach> coachList = List.of(new Coach("토미"));

        // when & then
        assertThatThrownBy(() -> new Coaches(coachList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치가_5명을_초과하면_예외가_발생한다() {
        // given
        List<Coach> coachList = List.of(
                new Coach("토미"), new Coach("제임스"), new Coach("포코"),
                new Coach("루피"), new Coach("크롱"), new Coach("해리")
        );

        // when & then
        assertThatThrownBy(() -> new Coaches(coachList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치_이름이_중복되면_예외가_발생한다() {
        // given
        List<Coach> coachList = List.of(
                new Coach("토미"),
                new Coach("토미") // 중복 이름
        );

        // when & then
        assertThatThrownBy(() -> new Coaches(coachList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}