package menu.domain;

public class Coach {
    private final CoachName name;
    private final InedibleFoods inedibleFoods;

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
}
