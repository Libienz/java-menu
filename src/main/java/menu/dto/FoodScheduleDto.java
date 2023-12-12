package menu.dto;

import java.util.List;

public class FoodScheduleDto {
    private final String coachName;
    private final List<String> foodSchedule;

    public FoodScheduleDto(String coachName, List<String> foodSchedule) {
        this.coachName = coachName;
        this.foodSchedule = foodSchedule;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getFoodSchedule() {
        return foodSchedule;
    }
}
