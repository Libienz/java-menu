package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.domain.CoachName;
import menu.domain.CoachNames;
import menu.domain.InedibleFoods;

public class InputView {
    private static final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_INEDIBLE_FOOD_MESSAGE_FORM = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public CoachNames inputCoachNames() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return inputMapper.mapToCoachNames(Console.readLine());
    }

    public InedibleFoods inputInedibleFoods(CoachName coachName) {
        System.out.printf(INPUT_INEDIBLE_FOOD_MESSAGE_FORM + "\n", coachName.getName());
        return inputMapper.mapToInedibleFood(Console.readLine());
    }
}
