package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> isInedibleMenu;

    public Coach(String name, List<String> isInedibleMenu) {
        this.name = name;
        this.isInedibleMenu = isInedibleMenu;
    }
}
