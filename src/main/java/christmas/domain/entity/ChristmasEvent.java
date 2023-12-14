package christmas.domain.entity;

public class ChristmasEvent {
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 25;

    public static Integer apply(VisitDate visitDate) {
        int date = visitDate.getVisitDate();
        if (date >= FIRST_DAY && date <= LAST_DAY) {
            return calculateEventPrice(date);
        }
        return 0;
    }

    private static Integer calculateEventPrice(int date) {
        return 1000 + (date - 1) * 100;
    }
}
