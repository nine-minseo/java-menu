package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printMenuResult(List<Category> categories, Coaches coaches) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        printCategories(categories);
        printCoachMenus(coaches);

        System.out.println("\n추천을 완료했습니다.");
    }

    private static void printCategories(List<Category> categories) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 카테고리");
        for (Category category : categories) {
            sb.append(" | ").append(category.getName());
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    private static void printCoachMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ").append(coach.getName());
            for (String menu : coach.getWeeklyMenus()) {
                sb.append(" | ").append(menu);
            }
            sb.append(" ]");
            System.out.println(sb);
        }
    }
}