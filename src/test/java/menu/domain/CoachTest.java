package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @Test
    void 코치_이름이_2글자_미만이면_예외가_발생한다() {
        // given
        String invalidName = "토";

        // when & then
        assertThatThrownBy(() -> new Coach(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치_이름이_4글자를_초과하면_예외가_발생한다() {
        // given
        String invalidName = "토미제임스";

        // when & then
        assertThatThrownBy(() -> new Coach(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 존재하지_않는_메뉴를_못_먹는_메뉴로_추가하면_예외가_발생한다() {
        // given
        Coach coach = new Coach("토미");
        String invalidMenu = "흙파먹기";

        // when & then
        assertThatThrownBy(() -> coach.addInedibleMenu(invalidMenu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"우동", "스시"})
    void 못_먹는_메뉴로_등록된_음식은_먹을_수_없다(String menuName) {
        // given
        Coach coach = new Coach("토미");
        coach.addInedibleMenu("우동");
        coach.addInedibleMenu("스시");

        // when
        boolean canEat = coach.canEat(menuName);

        // then
        assertThat(canEat).isFalse();
    }

    @Test
    void 이미_이번주에_추천받은_메뉴는_다시_먹을_수_없다() {
        // given
        Coach coach = new Coach("토미");
        coach.addWeeklyMenu("삼겹살");

        // when
        boolean canEat = coach.canEat("삼겹살");

        // then
        assertThat(canEat).isFalse();
    }
}