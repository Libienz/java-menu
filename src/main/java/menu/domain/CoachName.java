package menu.domain;

public class CoachName {
    private static final String INVALID_LENGTH_MESSAGE = "[ERROR] 코치 이름의 길이가 적절하지 않습니다";
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;

    private final String name;

    public CoachName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }
}
