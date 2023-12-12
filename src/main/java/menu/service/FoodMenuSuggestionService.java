package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.FoodCategory;
import menu.domain.FoodMenu;

public class FoodMenuSuggestionService {
    private static final int SUGGEST_INDEX = 0;

    public FoodMenu suggest(FoodCategory category) {
        String foodName = Randoms.shuffle(FoodMenu.findFoodsByCategory(category)).get(SUGGEST_INDEX);
        return FoodMenu.from(foodName);
    }
}
