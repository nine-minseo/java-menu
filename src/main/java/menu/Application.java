package menu;

import java.util.List;
import menu.view.InputView;
import menu.view.OutputView;
import java.util.function.Supplier;


public class Application {
    public static void main(String[] args) {
        OutputView.printRecommendStartMessage();

        List<String> coachNames = retryUntilValid(InputView::readCoachNames);


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
