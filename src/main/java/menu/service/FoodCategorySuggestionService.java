package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.FoodCategory;
import menu.domain.FoodMenu;

public class FoodCategorySuggestionService {
    private static final int MAX_CATEGORY_COUNT = 2;
    private static final int MIN_CATEGORY_CODE = 1;
    private static final int MAX_CATEGORY_CODE = 5;

    public FoodCategory suggest(List<FoodCategory> suggestedCategory) {
        while(true) {
            FoodCategory category = FoodCategory.from(Randoms.pickNumberInRange(MIN_CATEGORY_CODE, MAX_CATEGORY_CODE));
            int count = countCategorySuggested(suggestedCategory, category);
            if (count + 1 < MAX_CATEGORY_COUNT) {
                return category;
            }
        }
    }

    public int countCategorySuggested(List<FoodCategory> foodCategories, FoodCategory target) {
        return (int) foodCategories.stream()
                .filter(target::equals)
                .count();
    }
}
