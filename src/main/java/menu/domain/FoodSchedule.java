package menu.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class FoodSchedule {
    private final List<FoodMenu> schedule = new ArrayList<>();

    public void addSchedule(DayOfWeek dayOfWeek, FoodMenu foodMenu) {
        schedule.add(foodMenu);
    }

    public boolean contains(FoodMenu foodMenu) {
        return schedule.contains(foodMenu);
    }

    public List<FoodMenu> getSchedule() {
        return schedule;
    }
}
