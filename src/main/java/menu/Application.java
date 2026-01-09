package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.function.Supplier;


public class Application {
    public static void main(String[] args) {
        OutputView.printRecommendStartMessage();

        List<String> coachNames = retryUntilValid(InputView::readCoachNames);

        for (String name : coachNames) {
            List<String> isInedibleMenu = retryUntilValid(() -> InputView.readIsInedibleMenu(name));
            Coach coach = new Coach(name, isInedibleMenu);
        }

        List<String> categories = new ArrayList<>(List.of("일식", "한식", "중식", "아시안", "양식"));
        List<String> categoriesByDay = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            while (true) {
                String category = categories.get(Randoms.pickNumberInRange(0, 4));
                System.out.println(category);
                int categorieCount = (int) categoriesByDay.stream()
                        .filter(ctg -> ctg.equals(category))
                        .count();

                if (categorieCount < 2) {
                    categoriesByDay.add(category);
                    break;
                }
            }
        }

        System.out.println(categoriesByDay);
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
