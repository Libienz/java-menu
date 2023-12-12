package menu.controller;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.CoachNames;
import menu.domain.FoodMenu;
import menu.domain.FoodSchedule;
import menu.domain.InedibleFoods;
import menu.domain.MenuCategory;
import menu.domain.SelectedCategories;
import menu.dto.FoodScheduleDto;
import menu.dto.MenuCategoriesDto;
import menu.service.CategoryRecommendService;
import menu.service.FoodMenuRecommendService;
import menu.util.Repeater;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryRecommendService categoryRecommendService;
    private final FoodMenuRecommendService foodMenuRecommendService;

    public MainController(InputView inputView, OutputView outputView, CategoryRecommendService categoryRecommendService,
                          FoodMenuRecommendService foodMenuRecommendService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.categoryRecommendService = categoryRecommendService;
        this.foodMenuRecommendService = foodMenuRecommendService;
    }

    public void run() {
        outputView.printGreeting();
        List<Coach> coaches = inputCoaches();

        SelectedCategories selectedCategories = new SelectedCategories();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                continue;
            }
            MenuCategory recommend = categoryRecommendService.recommend();
            while (!selectedCategories.addCategory(recommend)) {
                recommend = categoryRecommendService.recommend();
            }

            for (Coach coach : coaches) {
                FoodMenu menu = foodMenuRecommendService.recommend(recommend);
                while (!coach.addSchedule(dayOfWeek, menu)) {
                    menu = foodMenuRecommendService.recommend(recommend);
                }
            }
        }

        //결과 출력
        outputView.printResultPrefixMessage();
        outputView.printMenuCategoriesMessage(MenuCategoriesDto.from(selectedCategories));
        coaches.stream()
                .map(FoodScheduleDto::from)
                .forEach(outputView::printFoodScheduled);
        outputView.printDone();
    }

    private List<Coach> inputCoaches() {
        CoachNames coachNames = Repeater.repeatUntilNoException(inputView::inputCoachNames);
        List<Coach> coaches = new ArrayList<>();
        for (CoachName coachName : coachNames.getCoachNames()) {
            InedibleFoods inedibleFoods = Repeater.repeatUntilNoException(
                    () -> inputView.inputInedibleFoods(coachName.getName()));
            coaches.add(new Coach(coachName, inedibleFoods, new FoodSchedule()));
        }
        return coaches;
    }
}
