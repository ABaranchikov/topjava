package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MealsInit {
    public static final List<Meal> STORAGE = new ArrayList<>();

    static {
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 1, 8, 0), "Завтрак", 400));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 1, 14, 0), "Обед", 1500));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 1, 20, 0), "Ужин", 700));

        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 2, 7, 0), "Завтрак", 500));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 2, 13, 0), "Обед", 1000));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 2, 18, 0), "Ужин", 700));

        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 3, 9, 0), "Завтрак", 300));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 3, 13, 0), "Обед", 1000));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 3, 19, 0), "Ужин", 1500));

        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 4, 9, 0), "Завтрак", 200));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 4, 13, 0), "Обед", 1500));
        STORAGE.add(new Meal(LocalDateTime.of(2018, Month.MAY, 4, 19, 0), "Ужин", 800));
    }
}
