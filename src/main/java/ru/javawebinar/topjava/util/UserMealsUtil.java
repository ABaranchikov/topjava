package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.TimeUtil.isBetween;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> result = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);

        result.forEach(System.out :: println);
    }

    public static List<UserMealWithExceed> getFilteredWithExceededByLoop(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesMap = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            LocalDate date = userMeal.getDateTime().toLocalDate();
            caloriesMap.put(date, caloriesMap.getOrDefault(date, 0) + userMeal.getCalories());
        }
        List<UserMealWithExceed> result = new ArrayList<>();
        for (UserMeal userMeal : mealList) {
            LocalTime time = userMeal.getDateTime().toLocalTime();
            if (isBetween(time, startTime, endTime)) {
                LocalDate date = userMeal.getDateTime().toLocalDate();
                int calories = caloriesMap.get(date);
                result.add(createUserMealWithExceed(userMeal, calories > caloriesPerDay));
            }
        }
        return result;
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> map = mealList.stream()
                .collect(Collectors.groupingBy(d -> d.getDateTime().toLocalDate(), Collectors.summingInt(UserMeal::getCalories)));

        return mealList.stream()
                .filter(d -> isBetween(d.getDateTime().toLocalTime(), startTime, endTime))
                .map(userMeal -> createUserMealWithExceed(userMeal, map.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    private static UserMealWithExceed createUserMealWithExceed(UserMeal userMeal, boolean isExceed) {
        return new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), isExceed);
    }
}


