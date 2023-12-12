package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.FoodCategory;

public class FoodCategorySuggestionService {
    private static final int MIN_CATEGORY_CODE = 1;
    private static final int MAX_CATEGORY_CODE = 5;

    public FoodCategory suggest() {
        return FoodCategory.from(Randoms.pickNumberInRange(MIN_CATEGORY_CODE, MAX_CATEGORY_CODE));
    }
}
