package menu.view;

public class MessageResolver {
    private static final String INPUT_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_INEDIBLE_MESSAGE_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String resolveInputCoachNamesMessage() {
        return INPUT_COACH_NAMES_MESSAGE;
    }

    public String resolveInputInedibleMessage(String coachName) {
        return String.format(INPUT_COACH_INEDIBLE_MESSAGE_FORMAT, coachName);
    }
}
