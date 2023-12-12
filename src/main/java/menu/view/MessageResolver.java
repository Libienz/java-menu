package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.FoodScheduleDto;
import menu.dto.MenuCategoriesDto;

public class MessageResolver {
    private static final String INPUT_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GREETING_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE_PREFIX = "메뉴 추천 결과입니다.";
    private static final String DONE_MESSAGE = "추천을 완료했습니다.";
    private static final String VALUES_MESSAGE_PREFIX = "[ ";
    private static final String VALUES_MESSAGE_DELIMITER = " | ";
    private static final String VALUES_MESSAGE_POSTFIX = " ]";
    private static final String INPUT_COACH_INEDIBLE_MESSAGE_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String resolveInputCoachNamesMessage() {
        return INPUT_COACH_NAMES_MESSAGE;
    }

    public String resolveInputInedibleMessage(String coachName) {
        return String.format(INPUT_COACH_INEDIBLE_MESSAGE_FORMAT, coachName);
    }

    public String resolveGreetingMessage() {
        return GREETING_MESSAGE;
    }

    public String resolveResultPrefixMessage() {
        return RESULT_MESSAGE_PREFIX;
    }

    public String resolveDayOfWeekMessage() {
        return formatValuesMessage(List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일"));
    }

    public String resolveCategoryMessage(MenuCategoriesDto menuCategoriesDto) {
        return formatValuesMessage(menuCategoriesDto.getMenuCategories());
    }

    public String resolveFoodScheduleMessage(FoodScheduleDto foodScheduleDto) {
        List<String> foodSchedule = foodScheduleDto.getFoodSchedule();
        foodSchedule.add(0, foodScheduleDto.getCoachName());
        return formatValuesMessage(foodSchedule);
    }

    public String resolveDoneMessage() {
        return DONE_MESSAGE;
    }

    public String formatValuesMessage(List<String> values) {
        return values.stream()
                .collect(Collectors.joining(VALUES_MESSAGE_DELIMITER, VALUES_MESSAGE_PREFIX, VALUES_MESSAGE_POSTFIX));
    }
}
