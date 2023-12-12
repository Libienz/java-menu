package menu.domain;

import static menu.domain.FoodCategory.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FoodMenu {
    //일식
    JAPANESE_MENU_1("규동", JAPANESE),
    JAPANESE_MENU_2("우동", JAPANESE),
    JAPANESE_MENU_3("미소시루", JAPANESE),
    JAPANESE_MENU_4("스시", JAPANESE),
    JAPANESE_MENU_5("가츠동", JAPANESE),
    JAPANESE_MENU_6("오니기리", JAPANESE),
    JAPANESE_MENU_7("하이라이스", JAPANESE),
    JAPANESE_MENU_8("라멘", JAPANESE),
    JAPANESE_MENU_9("오코노미야끼", JAPANESE),

    //한식
    KOREAN_MENU_1("김밥", KOREAN),
    KOREAN_MENU_2("김치찌개", KOREAN),
    KOREAN_MENU_3("쌈밥", KOREAN),
    KOREAN_MENU_4("된장찌개", KOREAN),
    KOREAN_MENU_5("비빔밥", KOREAN),
    KOREAN_MENU_6("칼국수", KOREAN),
    KOREAN_MENU_7("불고기", KOREAN),
    KOREAN_MENU_8("떡볶이", KOREAN),
    KOREAN_MENU_9("제육볶음", KOREAN),

    //중식
    CHINESE_MENU_1("깐풍기", CHINESE),
    CHINESE_MENU_2("볶음면", CHINESE),
    CHINESE_MENU_3("동파육", CHINESE),
    CHINESE_MENU_4("짜장면", CHINESE),
    CHINESE_MENU_5("짬뽕", CHINESE),
    CHINESE_MENU_6("마파두부", CHINESE),
    CHINESE_MENU_7("탕수육", CHINESE),
    CHINESE_MENU_8("토마토 달걀볶음", CHINESE),
    CHINESE_MENU_9("고추잡채", CHINESE),

    //아시안
    ASIAN_MENU_1("팟타이", ASIAN),
    ASIAN_MENU_2("카오 팟", ASIAN),
    ASIAN_MENU_3("나시고렝", ASIAN),
    ASIAN_MENU_4("파인애플 볶음밥", ASIAN),
    ASIAN_MENU_5("쌀국수", ASIAN),
    ASIAN_MENU_6("똠얌꿍", ASIAN),
    ASIAN_MENU_7("반미", ASIAN),
    ASIAN_MENU_8("월남쌈", ASIAN),
    ASIAN_MENU_9("분짜", ASIAN),

    //양식
    WESTERN_MENU_1("라자냐", ASIAN),
    WESTERN_MENU_2("그라탱", ASIAN),
    WESTERN_MENU_3("뇨끼", ASIAN),
    WESTERN_MENU_4("끼슈", ASIAN),
    WESTERN_MENU_5("프렌치 토스트", ASIAN),
    WESTERN_MENU_6("바게트", ASIAN),
    WESTERN_MENU_7("스파게티", ASIAN),
    WESTERN_MENU_8("피자", ASIAN),
    WESTERN_MENU_9("파니니", ASIAN),
    ;


    private final String description;
    private final FoodCategory category;

    FoodMenu(String description, FoodCategory category) {
        this.description = description;
        this.category = category;
    }

    public static List<String> findFoodsByCategory(FoodCategory foodCategory) {
        return Arrays.stream(FoodMenu.values())
                .filter(foodMenu -> foodMenu.category.equals(foodCategory))
                .map(FoodMenu::getDescription)
                .collect(Collectors.toList());
    }
    public String getDescription() {
        return description;
    }

    public FoodCategory getCategory() {
        return category;
    }
}
