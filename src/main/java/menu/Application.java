package menu;

import menu.config.MenuSuggestionConfig;

public class Application {
    public static void main(String[] args) {
        MenuSuggestionConfig menuSuggestionConfig = new MenuSuggestionConfig();
        menuSuggestionConfig.menuSuggestionController().run();
    }
}
