package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final int MAX_CATEGORY_COUNT = 2;

    private final CoachName name;
    private final InedibleFoods inedibleFoods;
    private List<FoodMenu> suggestedFoods = new ArrayList<>();

    public Coach(CoachName name, InedibleFoods inedibleFoods) {
        this.name = name;
        this.inedibleFoods = inedibleFoods;
    }

    public String getName() {
        return name.getName();
    }

    public boolean isEdible(FoodMenu foodMenu) {
        return !inedibleFoods.contains(foodMenu);
    }

    public boolean addSuggestion(FoodMenu suggestion) {
        if (!isEdible(suggestion)) {
            return false;
        }
        if (suggestedFoods.contains(suggestion)) {
            return false;
        }
        return suggestedFoods.add(suggestion);
    }
}
