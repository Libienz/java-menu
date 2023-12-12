package menu.domain;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private final CoachName coachName;
    private final InedibleFoods inedibleFoods;
    private final FoodSchedule foodSchedule;

    public Coach(CoachName coachName, InedibleFoods inedibleFoods, FoodSchedule foodSchedule) {
        this.coachName = coachName;
        this.inedibleFoods = inedibleFoods;
        this.foodSchedule = foodSchedule;
    }

    public boolean addSchedule(DayOfWeek dayOfWeek, FoodMenu foodMenu) {
        if (inedibleFoods.contains(foodMenu)) {
            return false;
        }
        if (foodSchedule.contains(foodMenu)) {
            return false;
        }
        foodSchedule.addSchedule(dayOfWeek, foodMenu);
        return true;
    }

    public String getName() {
        return coachName.getName();
    }

    public List<String> getFoodSchedule() {
        return foodSchedule.getSchedule().values().stream()
                .map(FoodMenu::getDescription)
                .collect(Collectors.toList());
    }
}
