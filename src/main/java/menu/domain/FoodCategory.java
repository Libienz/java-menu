package menu.domain;

import java.util.Arrays;

public enum FoodCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String NO_SUCH_CATEGORY_MESSAGE = "[ERROR] 해당하는 음식 카테고리가 존재하지 않습니다";

    private final int code;
    private final String description;

    FoodCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static FoodCategory from(int code) {
        return Arrays.stream(FoodCategory.values())
                .filter(foodCategory -> foodCategory.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_CATEGORY_MESSAGE));
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
