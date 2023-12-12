package menu.config;

import menu.controller.MenuSuggestionController;
import menu.service.FoodCategorySuggestionService;
import menu.service.FoodMenuSuggestionService;
import menu.view.InputMapper;
import menu.view.InputView;
import menu.view.OutputMessageResolver;
import menu.view.OutputView;

public class MenuSuggestionConfig {

    public InputView inputView() {
        return new InputView(inputMapper());
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public OutputView outputView() {
        return new OutputView(outputMessageResolver());
    }

    public OutputMessageResolver outputMessageResolver() {
        return new OutputMessageResolver();
    }

    public MenuSuggestionController menuSuggestionController() {
        return new MenuSuggestionController(inputView(), outputView(), foodCategorySuggestionService(),
                foodMenuSuggestionService());
    }

    public FoodMenuSuggestionService foodMenuSuggestionService() {
        return new FoodMenuSuggestionService();
    }

    public FoodCategorySuggestionService foodCategorySuggestionService() {
        return new FoodCategorySuggestionService();
    }
}
