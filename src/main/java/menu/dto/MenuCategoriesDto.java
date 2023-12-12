package menu.dto;

import java.util.List;
import menu.domain.SelectedCategories;

public class MenuCategoriesDto {
    private final List<String> menuCategories;

    private MenuCategoriesDto(List<String> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public static MenuCategoriesDto from(SelectedCategories selectedCategories) {
        return new MenuCategoriesDto(selectedCategories.getSelectedCategoryNames());
    }

    public List<String> getMenuCategories() {
        return menuCategories;
    }
}
