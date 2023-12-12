package menu.config;

import menu.controller.MainController;
import menu.service.CategoryRecommendService;
import menu.service.FoodMenuRecommendService;
import menu.view.InputMapper;
import menu.view.InputView;
import menu.view.MessageResolver;
import menu.view.OutputView;

public class Config {
    public InputView inputView() {
        return new InputView(inputMapper(), messageResolver());
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public MainController mainController() {
        return new MainController(inputView(), outputView(), categoryRecommendService(), foodMenuRecommendService());
    }

    public CategoryRecommendService categoryRecommendService() {
        return new CategoryRecommendService();
    }

    public FoodMenuRecommendService foodMenuRecommendService() {
        return new FoodMenuRecommendService();
    }
}
