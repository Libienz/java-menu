package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.CoachNames;
import menu.domain.FoodCategory;
import menu.domain.InedibleFoods;
import menu.service.FoodCategorySuggestionService;
import menu.service.FoodMenuSuggestionService;
import menu.util.Repeater;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuSuggestionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final FoodCategorySuggestionService foodCategorySuggestionService;
    private final FoodMenuSuggestionService foodMenuSuggestionService;

    public MenuSuggestionController(InputView inputView, OutputView outputView,
                                    FoodCategorySuggestionService foodCategorySuggestionService,
                                    FoodMenuSuggestionService foodMenuSuggestionService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.foodCategorySuggestionService = foodCategorySuggestionService;
        this.foodMenuSuggestionService = foodMenuSuggestionService;
    }

    public void run() {
        outputView.printGreeting();

        CoachNames coachNames = Repeater.repeatUntilNoException(inputView::inputCoachNames);
        List<Coach> coaches = new ArrayList<>();

        for (CoachName coachName : coachNames.getCoachNames()) {
            InedibleFoods inedibleFoods = Repeater.repeatUntilNoException(
                    () -> inputView.inputInedibleFoods(coachName));
            coaches.add(new Coach(coachName, inputView.inputInedibleFoods(coachName)));
        }

        List<FoodCategory> foodCategories = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FoodCategory suggested = foodCategorySuggestionService.suggest(foodCategories);
            foodCategories.add(suggested);
            for (Coach coach : coaches) {
                foodMenuSuggestionService.suggest(suggested, coach);
            }
        }

        outputView.printResult(coaches, foodCategories);
        outputView.printDone();

//        inputView.inputInedibleFoods();
    }
}
