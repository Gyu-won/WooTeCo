package christmas.domain.entity;

public class DayEvent {
    public static boolean applicableHolidayEvent(VisitDate visitDate) {
        int weekday = visitDate.getVisitDate() % 7;
        return weekday == 1 || weekday == 2;
    }

    public static Integer applyHoliday() {
        return 1;
    }

    public static Integer applyWeekday() {
        return 1;
    }
}
