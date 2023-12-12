package menu.domain;

import static menu.domain.MenuCategory.ASIAN;
import static menu.domain.MenuCategory.CHINESE;
import static menu.domain.MenuCategory.JAPANESE;
import static menu.domain.MenuCategory.KOREAN;
import static menu.domain.MenuCategory.WESTERN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    KOREAN_MENU_9(KOREAN, "제육볶음"),

    //중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    CHINESE_MENU_1(CHINESE, "깐풍기"),
    CHINESE_MENU_2(CHINESE, "볶음면"),
    CHINESE_MENU_3(CHINESE, "동파육"),
    CHINESE_MENU_4(CHINESE, "짜장면"),
    CHINESE_MENU_5(CHINESE, "짬뽕"),
    CHINESE_MENU_6(CHINESE, "마파두부"),
    CHINESE_MENU_7(CHINESE, "탕수육"),
    CHINESE_MENU_8(CHINESE, "토마토 달걀볶음"),
    CHINESE_MENU_9(CHINESE, "고추잡채"),

    //아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    ASIAN_MENU_1(ASIAN, "팟타이"),
    ASIAN_MENU_2(ASIAN, "카오 팟"),
    ASIAN_MENU_3(ASIAN, "나시고렝"),
    ASIAN_MENU_4(ASIAN, "파인애플 볶음밥"),
    ASIAN_MENU_5(ASIAN, "쌀국수"),
    ASIAN_MENU_6(ASIAN, "똠얌꿍"),
    ASIAN_MENU_7(ASIAN, "반미"),
    ASIAN_MENU_8(ASIAN, "월남쌈"),
    ASIAN_MENU_9(ASIAN, "분짜"),
    //양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
    WESTERN_MENU_1(WESTERN, "라자냐"),
    WESTERN_MENU_2(WESTERN, "그라탱"),
    WESTERN_MENU_3(WESTERN, "뇨끼"),
    WESTERN_MENU_4(WESTERN, "끼슈"),
    WESTERN_MENU_5(WESTERN, "프렌치 토스트"),
    WESTERN_MENU_6(WESTERN, "바게트"),
    WESTERN_MENU_7(WESTERN, "스파게티"),
    WESTERN_MENU_8(WESTERN, "피자"),
    WESTERN_MENU_9(WESTERN, "파니니");


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

    public static List<String> findByCategory(MenuCategory menuCategory) {
        return Arrays.stream(FoodMenu.values())
                .filter(foodMenu -> foodMenu.menuCategory.equals(menuCategory))
                .map(FoodMenu::getDescription)
                .collect(Collectors.toList());
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public String getDescription() {
        return description;
    }
}
