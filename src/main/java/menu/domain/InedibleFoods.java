package menu.domain;

import java.util.List;

public class InedibleFoods {
    private static final String INVALID_COUNT_OF_INEDIBLE = "[ERROR] 먹지 못하는 음식 개수가 범위에 맞지 않습니다";
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 2;

    private final List<FoodMenu> inedible;

    public InedibleFoods(List<FoodMenu> inedible) {
        validate(inedible);
        this.inedible = inedible;
    }

    public boolean contains(FoodMenu foodMenu) {
        return inedible.contains(foodMenu);
    }
    
    private void validate(List<FoodMenu> inedible) {
        validateCount(inedible);
    }

    private void validateCount(List<FoodMenu> inedible) {
        if (inedible.size() > MAX_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_OF_INEDIBLE);
        }
    }
}
