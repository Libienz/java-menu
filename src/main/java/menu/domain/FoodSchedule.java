package menu.domain;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class FoodSchedule {
    private final Map<DayOfWeek, FoodMenu> schedule = new HashMap<>();

    public void addSchedule(DayOfWeek dayOfWeek, FoodMenu foodMenu) {
        schedule.put(dayOfWeek, foodMenu);
    }

    public boolean contains(FoodMenu foodMenu) {
        return schedule.containsValue(foodMenu);
    }

    public Map<DayOfWeek, FoodMenu> getSchedule() {
        return schedule;
    }
}
