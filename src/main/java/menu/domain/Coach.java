package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> inedibleMenus;
    private final List<String> weeklyMenus;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.inedibleMenus = new ArrayList<>();
        this.weeklyMenus = new ArrayList<>();
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    public void addInedibleMenu(String menu) {
        if (menu == null || menu.isBlank()) {
            return;
        }
        MenuRepository.validateMenuExists(menu);
        this.inedibleMenus.add(menu);
    }

    public void addWeeklyMenu(String menu) {
        this.weeklyMenus.add(menu);
    }

    public boolean canEat(String menu) {
        return !inedibleMenus.contains(menu) && !weeklyMenus.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getWeeklyMenus() {
        return new ArrayList<>(weeklyMenus);
    }
}