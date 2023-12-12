package menu.domain;

import java.util.List;

public class InedibleFoods {
    private static final String INVALID_LENGTH_MESSAGE = "[ERROR] 먹을 수 없는 음식의 개수가 범위를 벗어납니다";
    private static final int MIN_LENGTH = 0;
    private static final int MAX_LENGTH = 2;

    private final List<FoodMenu> inedibleFoods;

    public InedibleFoods(List<FoodMenu> inedibleFoods) {
        validate(inedibleFoods);
        this.inedibleFoods = inedibleFoods;
    }

    public boolean contains(FoodMenu foodMenu) {
        return inedibleFoods.contains(foodMenu);
    }

    private void validate(List<FoodMenu> inedibleFoods) {
        validateLength(inedibleFoods);
    }

    private void validateLength(List<FoodMenu> inedibleFoods) {
        if (inedibleFoods.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }
}
