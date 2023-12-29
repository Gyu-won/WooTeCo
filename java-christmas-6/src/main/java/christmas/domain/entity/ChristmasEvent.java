package christmas.domain.entity;

public class ChristmasEvent {
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 25;

    public static Integer apply(Integer visitDate) {
        if (visitDate >= FIRST_DAY && visitDate <= LAST_DAY) {
            return calculateEventPrice(visitDate);
        }
        return 0;
    }

    private static Integer calculateEventPrice(int visitDate) {
        return 1000 + (visitDate - 1) * 100;
    }
}
