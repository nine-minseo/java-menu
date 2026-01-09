package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class OutputView {
    public static void printRecommendStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printRecommendedMenuMessage() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printCategories(List<String> categories) {
        List<String> printCategories = new ArrayList<>(categories);
        printCategories.addFirst("카테고리");
        String result = printCategories.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));

        System.out.println(result);
    }

    public static void printCoachMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            String name = coach.getName();
            List<String> fixedMenu = coach.getFixedMenu();

            List<String> printMenus = new ArrayList<>(fixedMenu);
            printMenus.addFirst(name);

            String result = printMenus.stream()
                    .collect(Collectors.joining(" | ", "[ ", " ]"));

            System.out.println(result);
        }
    }

    public static void printRecommendEndMessage() {
        System.out.println("\n추천을 완료했습니다.");
    }
}
