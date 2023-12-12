package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CoachName;
import menu.domain.CoachNames;
import menu.domain.FoodMenu;
import menu.domain.InedibleFoods;

public class InputMapper {
    private static final String SEPARATOR = ",";
    public CoachNames mapToCoachNames(String input) {
        return new CoachNames(splitBySeparator(input)
                .stream()
                .map(CoachName::new)
                .collect(Collectors.toList()));
    }

    public InedibleFoods mapToInedibleFood(String input) {
        if (input.isEmpty()) {
            return new InedibleFoods(new ArrayList<FoodMenu>());
        }
        return new InedibleFoods(splitBySeparator(input)
                .stream()
                .map(FoodMenu::from)
                .collect(Collectors.toList()));
    }

    private List<String> splitBySeparator(String input) {
        return Arrays.asList(input.split(SEPARATOR));
    }
}
