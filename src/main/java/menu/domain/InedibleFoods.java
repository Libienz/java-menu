package menu.domain;

import java.util.List;

public class InedibleFoods {
    private final List<FoodMenu> inedibleFoods;

    public InedibleFoods(List<FoodMenu> inedibleFoods) {
        this.inedibleFoods = inedibleFoods;
    }

    public boolean contains(FoodMenu foodMenu) {
        return inedibleFoods.contains(foodMenu);
    }
}
