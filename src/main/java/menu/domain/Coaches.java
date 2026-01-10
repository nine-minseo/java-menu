package menu.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCount(coaches);
        validateDuplicate(coaches);
        this.coaches = coaches;
    }

    private void validateCount(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Coach> coaches) {
        Set<String> uniqueNames = new HashSet<>();
        for (Coach coach : coaches) {
            uniqueNames.add(coach.getName());
        }
        if (uniqueNames.size() != coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 중복될 수 없습니다.");
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}