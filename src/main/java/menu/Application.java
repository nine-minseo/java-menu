package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.function.Supplier;


public class Application {
    public static void main(String[] args) {
        OutputView.printRecommendStartMessage();

        List<String> coachNames = retryUntilValid(InputView::readCoachNames);
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }

        for (Coach coach : coaches) {
            List<String> isInedibleMenu = retryUntilValid(() -> InputView.readIsInedibleMenu(coach.getName()));
            coach.setIsInedibleMenu(isInedibleMenu);
        }

        List<String> japaneseFood = new ArrayList<>(
                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        List<String> koreanFood = new ArrayList<>(
                List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        List<String> chineseFood = new ArrayList<>(
                List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        List<String> asianFood = new ArrayList<>(
                List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        List<String> westernFood = new ArrayList<>(
                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

        Map<String, List<String>> map = Map.of(
                "일식", japaneseFood,
                "한식", koreanFood,
                "중식", chineseFood,
                "아시안", asianFood,
                "양식", westernFood
        );

        List<String> categories = new ArrayList<>(map.keySet());
        List<String> categoriesByDay = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            while (true) {
                String category = categories.get(Randoms.pickNumberInRange(0, 4));
                int categorieCount = (int) categoriesByDay.stream()
                        .filter(ctg -> ctg.equals(category))
                        .count();

                if (categorieCount < 2) {
                    categoriesByDay.add(category);
                    break;
                }
            }
        }

        for (String category : categoriesByDay) {
            for (Coach coach : coaches) {
                List<String> isInedibleMenu = coach.getIsInedibleMenu();
                while (true) {
                    String menu = Randoms.shuffle(map.get(category)).get(0);

                    if (!isInedibleMenu.contains(menu)) {
                        coach.add(menu);
                        break;
                    }
                }
            }
        }

        OutputView.printCategories(categoriesByDay);
        OutputView.printCoachMenus(coaches);
        OutputView.printRecommendEndMessage();
    }

    private static <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
