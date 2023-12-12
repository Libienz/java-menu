package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.CoachNames;
import menu.domain.InedibleFoods;

public class InputView {
    private final InputMapper inputMapper;
    private final MessageResolver messageResolver;

    public InputView(InputMapper inputMapper, MessageResolver messageResolver) {
        this.inputMapper = inputMapper;
        this.messageResolver = messageResolver;
    }

    public CoachNames inputCoachNames() {
        System.out.println(messageResolver.resolveInputCoachNamesMessage());
        return inputMapper.mapToCoachNames(Console.readLine());
    }

    public InedibleFoods inputInedibleFoods(String coachName) {
        System.out.println(messageResolver.resolveInputInedibleMessage(coachName));
        return inputMapper.mapToInedible(Console.readLine());
    }
}
