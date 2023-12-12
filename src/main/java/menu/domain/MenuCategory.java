package menu.domain;

import java.util.Arrays;

public enum MenuCategory {
    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private static final String NO_SUCH_CATEGORY_MESSAGE = "[ERROR] 해당하는 카테고리가 존재하지 않습니다";
    private final int code;

    MenuCategory(int code) {
        this.code = code;
    }

    public static MenuCategory from(int code) {
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_CATEGORY_MESSAGE));
    }
}
