package menu.domain;

import java.util.List;

public class CoachNames {
    private static final String INVALID_COACH_COUNT_MESSAGE = "[ERROR] 입력된 코치 수가 범위를 벗어납니다";
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;

    private final List<CoachName> coachNames;

    public CoachNames(List<CoachName> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
    }

    public List<CoachName> getCoachNames() {
        return coachNames;
    }

    private void validate(List<CoachName> coachNames) {
        validateSize(coachNames);
    }

    private void validateSize(List<CoachName> coachNames) {
        if (coachNames.size() < MIN_SIZE || coachNames.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT_MESSAGE);
        }
    }
}
