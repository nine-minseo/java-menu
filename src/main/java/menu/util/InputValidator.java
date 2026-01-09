package menu.util;

import java.util.List;

public class InputValidator {
    public static void validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
    }

    public static void validateDuplicate(List<String> input) {
        if (input.stream()
                .distinct()
                .count() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateHasBlankName(List<String> input) {
        if (input.stream()
                .anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("[ERROR] 입력하지 않은 코치 이름이 있습니다.");
        }
    }

    public static void validateNameLengthRange(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름으로 최소 2글자, 최대 4글자를 입력해야 합니다.");
        }
    }

    public static void validateCoachCount(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명 입력해야 합니다.");
        }
    }
}
