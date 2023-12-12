package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CoachName;
import menu.domain.CoachNames;
import menu.domain.FoodMenu;
import menu.domain.InedibleFoods;

public class InputMapper {
    private static final String DELIMITER = ",";

    public CoachNames mapToCoachNames(String input) {
        List<CoachName> names = Arrays.stream(input.split(DELIMITER))
                .map(CoachName::new)
                .collect(Collectors.toList());
        return new CoachNames(names);
    }

    public InedibleFoods mapToInedible(String input) {
        List<FoodMenu> inedible = Arrays.stream(input.split(DELIMITER))
                .map(FoodMenu::from)
                .collect(Collectors.toList());
        return new InedibleFoods(inedible);
    }
}
