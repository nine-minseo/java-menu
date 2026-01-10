package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    private final MenuRecommender menuRecommender;

    public Controller() {
        this.menuRecommender = new MenuRecommender();
    }

    public void run() {
        OutputView.printStartMessage();

        Coaches coaches = retryUntilValid(this::getCoaches);
        getInedibleMenus(coaches);

        List<Category> categories = menuRecommender.recommend(coaches);

        OutputView.printMenuResult(categories, coaches);
    }

    private Coaches getCoaches() {
        List<String> names = InputView.readCoachNames();
        List<Coach> coachList = new ArrayList<>();
        for (String name : names) {
            coachList.add(new Coach(name));
        }
        return new Coaches(coachList);
    }

    private void getInedibleMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            retryUntilValid(() -> {
                List<String> menus = InputView.readInedibleMenus(coach.getName());
                for (String menu : menus) {
                    coach.addInedibleMenu(menu);
                }
                return null;
            });
        }
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