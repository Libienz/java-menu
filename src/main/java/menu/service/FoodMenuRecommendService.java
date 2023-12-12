package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.FoodMenu;
import menu.domain.MenuCategory;

public class FoodMenuRecommendService {

    public FoodMenu recommend(MenuCategory menuCategory) {
        String foodName = Randoms.shuffle(FoodMenu.findByCategory(menuCategory)).get(0);
        return FoodMenu.from(foodName);
    }
}
