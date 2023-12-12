package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectedCategories {
    private static final int MAX_SAME_CATEGORY_COUNT = 2;
    private final List<MenuCategory> menuCategories = new ArrayList<>();

    public boolean addCategory(MenuCategory menuCategory) {
        if (countSameCategory(menuCategory) > MAX_SAME_CATEGORY_COUNT) {
            return false;
        }
        menuCategories.add(menuCategory);
        return true;
    }

    private int countSameCategory(MenuCategory menuCategory) {
        return (int) menuCategories.stream()
                .filter(menuCategory::equals)
                .count();
    }

    public List<String> getSelectedCategoryNames() {
        return menuCategories.stream()
                .map(MenuCategory::getName)
                .collect(Collectors.toList());
    }
}
