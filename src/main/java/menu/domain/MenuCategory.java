package menu.domain;

import java.util.Arrays;

public enum MenuCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String NO_SUCH_CATEGORY_MESSAGE = "[ERROR] 해당하는 카테고리가 존재하지 않습니다";
    private final int code;
    private final String name;

    MenuCategory(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MenuCategory from(int code) {
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_CATEGORY_MESSAGE));
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
