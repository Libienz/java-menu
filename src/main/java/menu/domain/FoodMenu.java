package menu.domain;

import static menu.domain.MenuCategory.JAPANESE;
import static menu.domain.MenuCategory.KOREAN;

import java.util.Arrays;

public enum FoodMenu {
    //일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    JAPANESE_MENU_1(JAPANESE, "규동"),
    JAPANESE_MENU_2(JAPANESE, "우동"),
    JAPANESE_MENU_3(JAPANESE, "미소시루"),
    JAPANESE_MENU_4(JAPANESE, "스시"),
    JAPANESE_MENU_5(JAPANESE, "가츠동"),
    JAPANESE_MENU_6(JAPANESE, "오니기리"),
    JAPANESE_MENU_7(JAPANESE, "하이라이스"),
    JAPANESE_MENU_8(JAPANESE, "라멘"),
    JAPANESE_MENU_9(JAPANESE, "오코노미야끼"),
    //한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    KOREAN_MENU_1(KOREAN, "김밥"),
    KOREAN_MENU_2(KOREAN, "김치찌개"),
    KOREAN_MENU_3(KOREAN, "쌈밥"),
    KOREAN_MENU_4(KOREAN, "된장찌개"),
    KOREAN_MENU_5(KOREAN, "비빔밥"),
    KOREAN_MENU_6(KOREAN, "칼국수"),
    KOREAN_MENU_7(KOREAN, "불고기"),
    KOREAN_MENU_8(KOREAN, "떡볶이"),
    KOREAN_MENU_9(KOREAN, "제육볶음");

    private static final String NO_SUCH_MENU_MESSAGE = "[ERROR] 해당하는 메뉴를 찾을 수 없습니다";

    private final MenuCategory menuCategory;
    private final String description;

    FoodMenu(MenuCategory menuCategory, String description) {
        this.menuCategory = menuCategory;
        this.description = description;
    }

    public static FoodMenu from(String name) {
        return Arrays.stream(FoodMenu.values())
                .filter(foodMenu -> foodMenu.description.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_MENU_MESSAGE));
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public String getDescription() {
        return description;
    }
}
