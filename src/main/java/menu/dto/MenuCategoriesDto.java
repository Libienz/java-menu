package menu.dto;

import java.util.List;

public class MenuCategoriesDto {
    private final List<String> menuCategories;

    public MenuCategoriesDto(List<String> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<String> getMenuCategories() {
        return menuCategories;
    }
}
