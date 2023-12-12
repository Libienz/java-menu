package menu.view;

import menu.dto.FoodScheduleDto;
import menu.dto.MenuCategoriesDto;

public class OutputView {
    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printGreeting() {
        System.out.println(messageResolver.resolveGreetingMessage());
    }

    public void printResultPrefixMessage() {
        System.out.println(messageResolver.resolveResultPrefixMessage());
    }

    public void printMenuCategoriesMessage(MenuCategoriesDto menuCategoriesDto) {
        System.out.println(messageResolver.resolveCategoryMessage(menuCategoriesDto));
    }

    public void printFoodScheduled(FoodScheduleDto foodScheduleDto) {
        System.out.println(messageResolver.resolveFoodScheduleMessage(foodScheduleDto));
    }

    public void printDone() {
        System.out.println(messageResolver.resolveDoneMessage());
    }
}
