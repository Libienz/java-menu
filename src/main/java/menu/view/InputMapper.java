package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CoachName;
import menu.domain.CoachNames;

public class InputMapper {
    private static final String DELIMITER = ",";

    public CoachNames mapToCoachNames(String input) {
        List<CoachName> names = Arrays.stream(input.split(DELIMITER))
                .map(CoachName::new)
                .collect(Collectors.toList());
        return new CoachNames(names);
    }
}
