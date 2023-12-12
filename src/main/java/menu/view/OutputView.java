package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.FoodCategory;

public class OutputView {
    private final OutputMessageResolver outputMessageResolver;

    public OutputView(OutputMessageResolver outputMessageResolver) {
        this.outputMessageResolver = outputMessageResolver;
    }

    public void printGreeting() {
        System.out.println(outputMessageResolver.resolveGreetingMessage());
    }

    public void printDone() {
        System.out.println(outputMessageResolver.resolveDoneMessage());
    }

    public void printResult(List<Coach> coaches, List<FoodCategory> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(outputMessageResolver.resolveDayOfWeekMessage());
        System.out.println(outputMessageResolver.resolveSelectedCategoryMessage(categories));
        coaches.forEach(coach -> System.out.println(outputMessageResolver.resolveCoachFoodsMessage(coach)));
    }

}
