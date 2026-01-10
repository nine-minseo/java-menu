package menu.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private static final Map<Category, List<String>> menus = new HashMap<>();

    static {
        menus.put(Category.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menus.put(Category.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menus.put(Category.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menus.put(Category.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menus.put(Category.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public static List<String> getMenusByCategory(Category category) {
        return menus.getOrDefault(category, Collections.emptyList());
    }

    public static void validateMenuExists(String menuName) {
        boolean exists = menus.values().stream()
                .anyMatch(menuList -> menuList.contains(menuName));
        if (!exists) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다: " + menuName);
        }
    }
}