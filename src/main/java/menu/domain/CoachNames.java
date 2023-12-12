package menu.domain;

import java.util.List;

public class CoachNames {
    private static final String INVALID_COUNT_OF_NAMES_MESSAGE = "[ERROR] 등록을 시도한 코치의 수가 범위를 벗어납니다";
    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private final List<CoachName> coachNames;

    public CoachNames(List<CoachName> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
    }

    public List<CoachName> getCoachNames() {
        return coachNames;
    }

    private void validate(List<CoachName> coachNames) {
        validateCount(coachNames);
    }

    private void validateCount(List<CoachName> coachNames) {
        if (coachNames.size() < MIN_COACH_COUNT || coachNames.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_OF_NAMES_MESSAGE);
        }
    }
}
