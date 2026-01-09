package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.util.InputValidator;

public class InputView {
    public static List<String> readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();

        InputValidator.validateHasInput(input);

        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        InputValidator.validateDuplicate(names);
        InputValidator.validateHasBlankName(names);

        for (String name : names) {
            InputValidator.validateNameLengthRange(name);
        }

        InputValidator.validateCoachCount(names);

        return names;
    }

    public static List<String> readIsInedibleMenu(String coach) {
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();

        List<String> menus = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        InputValidator.validateDuplicate(menus);
        InputValidator.validateHasBlankName(menus);
        InputValidator.validateMenuCount(menus);

//        for (String name : menus) {
//            InputValidator.validateMenuInMenuBoard(name);
//        }

        return menus;
    }
}
