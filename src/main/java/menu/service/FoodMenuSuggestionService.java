package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.FoodCategory;
import menu.domain.FoodMenu;

public class FoodMenuSuggestionService {
    private static final int SUGGEST_INDEX = 0;

    public void suggest(FoodCategory category, Coach coach) {
        String foodName = Randoms.shuffle(FoodMenu.findFoodsByCategory(category)).get(SUGGEST_INDEX);
        FoodMenu suggestedFood = FoodMenu.from(foodName);
        while (!coach.addSuggestion(suggestedFood)) {
            continue;
        }
    }
}
