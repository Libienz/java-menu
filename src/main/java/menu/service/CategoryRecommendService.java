package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;

public class CategoryRecommendService {
    private static final int MIN_CODE = 1;
    private static final int MAX_CODE = 5;

    public MenuCategory recommend() {
        return MenuCategory.from(Randoms.pickNumberInRange(MIN_CODE, MAX_CODE));
    }
}
