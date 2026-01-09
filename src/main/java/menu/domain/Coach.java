package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private String name;
    private List<String> isInedibleMenu;
    private List<String> fixedMenu;

    public Coach(String name) {
        this.name = name;
        isInedibleMenu = new ArrayList<>();
        fixedMenu = new ArrayList<>();
    }

    public void setIsInedibleMenu(List<String> isInedibleMenu) {
        this.isInedibleMenu = new ArrayList<>(isInedibleMenu);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIsInedibleMenu() {
        return Collections.unmodifiableList(isInedibleMenu);
    }

    public List<String> getFixedMenu() {
        return Collections.unmodifiableList(fixedMenu);
    }

    public void add(String menu) {
        fixedMenu.add(menu);
    }
}
