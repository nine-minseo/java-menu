package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {
    private static final int DAYS_OF_WEEK = 5;

    public List<Category> recommend(Coaches coaches) {
        List<Category> categories = pickCategories();

        for (Category category : categories) {
            recommendDailyMenu(coaches, category);
        }
        return categories;
    }

    private List<Category> pickCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < DAYS_OF_WEEK) {
            Category category = Category.from(Randoms.pickNumberInRange(1, 5));
            if (isCategoryValid(categories, category)) {
                categories.add(category);
            }
        }
        return categories;
    }

    private boolean isCategoryValid(List<Category> categories, Category category) {
        long count = categories.stream()
                .filter(c -> c == category)
                .count();
        return count < 2;
    }

    private void recommendDailyMenu(Coaches coaches, Category category) {
        List<String> menus = MenuRepository.getMenusByCategory(category);
        for (Coach coach : coaches.getCoaches()) {
            String recommendedMenu = pickMenuForCoach(menus, coach);
            coach.addWeeklyMenu(recommendedMenu);
        }
    }

    private String pickMenuForCoach(List<String> menus, Coach coach) {
        String menu;
        do {
            List<String> shuffled = Randoms.shuffle(menus);
            menu = shuffled.get(0);
        } while (!coach.canEat(menu));
        return menu;
    }
}