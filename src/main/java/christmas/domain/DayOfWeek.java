package christmas.domain;

public enum DayOfWeek {
    FRIDAY(1),
    SATURDAY(2);

    public static final Integer DAYS_IN_WEEK = 7;
    private final Integer value;

    DayOfWeek(Integer value) {
        this.value = value;
    }

    public static boolean isWeekday(Integer day) {
        return !isHoliday(day);
    }

    public static boolean isHoliday(Integer day) {
        return day.equals(FRIDAY.value) || day.equals(SATURDAY.value);
    }
}
