package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.FoodCategory;

public class OutputMessageResolver {
    private static final String GREETING_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String DONE_MESSAGE = "추천을 완료했습니다.";
    private static final String DELIMITER = "|";
    private static final String PREFIX = "[ ";
    private static final String POSTFIX = " ]";

    public String resolveGreetingMessage() {
        return GREETING_MESSAGE;
    }

    public String resolveDayOfWeekMessage() {
        List<String> daysOfWeek = List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        return resolveArrayListMessage(daysOfWeek);
    }

    public String resolveSelectedCategoryMessage(List<FoodCategory> foodCategories) {
        List<String> form = new ArrayList<>();
        form.add("카테고리");
        foodCategories.forEach(foodCategory -> form.add(foodCategory.getDescription()));
        return resolveArrayListMessage(form);
    }

    public String resolveCoachFoodsMessage(Coach coach) {
        List<String> form = new ArrayList<>();
        form.add(coach.getName());
        coach.getSuggestedFoods()
                .forEach(foodMenu -> form.add(foodMenu.getDescription()));
        return resolveArrayListMessage(form);
    }

    public String resolveDoneMessage() {
        return DONE_MESSAGE;
    }
    private String resolveArrayListMessage(List<String> target) {
        return target.stream()
                .collect(Collectors.joining(" | ", PREFIX, POSTFIX));
    }
}
