package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UserMeal {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "dateTime=" + dateTime.format(formatter) +
                ", description='" + description + "'" +
                ", calories=" + calories +
                '}';
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMeal)) return false;
        UserMeal userMeal = (UserMeal) o;
        return calories == userMeal.calories &&
                Objects.equals(dateTime, userMeal.dateTime) &&
                Objects.equals(description, userMeal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, description, calories);
    }
}
