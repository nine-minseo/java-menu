//package menu;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import camp.nextstep.edu.missionutils.test.NsTest;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//class ApplicationTest extends NsTest {
//
//    @Test
//    void 전체_기능_정상_작동_테스트() {
//        assertRandomNumberInListTest(
//                () -> {
//                    // given
//                    // 입력값: 코치 이름 -> 토미 못 먹는 거 -> 제임스 못 먹는 거
//                    run("토미,제임스", "우동,스시", "뇨끼,월남쌈");
//
//                    // when (run 내부에서 프로그램 실행됨)
//
//                    // then
//                    // 출력 결과에 아래 문자열들이 포함되어 있는지 확인
//                    assertThat(output()).contains(
//                            "점심 메뉴 추천을 시작합니다.",
//                            "메뉴 추천 결과입니다.",
//                            "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]",
//                            "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]",
//                            "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]",
//                            "추천을 완료했습니다."
//                    );
//                },
//                // Randoms.pickNumberInRangeMock (카테고리 순서: 2(한식), 2(한식), 1(일식), 3(중식), 4(아시안))
//                List.of(2, 2, 1, 3, 4),
//                // Randoms.shuffleMock (각 요일별 코치들이 뽑을 메뉴 순서)
//                // 월(한식): 토미(쌈밥), 제임스(된장찌개)
//                // 화(한식): 토미(김치찌개), 제임스(비빔밥)
//                // 수(일식): 토미(미소시루), 제임스(가츠동) ...
//                List.of("쌈밥", "된장찌개", "김치찌개", "비빔밥", "미소시루", "가츠동", "짜장면", "토마토 달걀볶음", "팟타이", "파인애플 볶음밥")
//        );
//    }
//
//    @Test
//    void 코치_이름_입력_예외_재입력_테스트() {
//        assertSimpleTest(() -> {
//            // given (잘못된 입력 후 정상 입력)
//            // 1. "토미" (1명이니까 에러) -> 2. "토미,제임스" (정상)
//            // 못 먹는 메뉴는 그냥 엔터(빈 값) 입력
//            runException("토미", "토미,제임스", "\n", "\n");
//
//            // then
//            assertThat(output()).contains(
//                    "[ERROR] 코치는 최소 2명",
//                    "점심 메뉴 추천을 시작합니다."
//            );
//        });
//    }
//
//    @Test
//    void 없는_메뉴_입력_예외_재입력_테스트() {
//        assertSimpleTest(() -> {
//            // given
//            // 코치 정상 입력 -> 토미가 "이상한거" 입력(에러) -> 다시 "우동" 입력
//            runException("토미,제임스", "이상한거", "우동", "\n");
//
//            // then
//            assertThat(output()).contains("[ERROR] 존재하지 않는 메뉴입니다");
//        });
//    }
//
//    @Override
//    protected void runMain() {
//        Application.main(new String[]{});
//    }
//}