package christmas.domain.entity;

public class ChristmasEvent {
    public static Integer apply(Order order, VisitDate visitDate) {
        int date = visitDate.getVisitDate();
        if (date >= 1 && date <= 25) {
            return calculateEventPrice(order, date);
        }
        return 0;
    }

    private static Integer calculateEventPrice(Order order, int date) {
        return 1000 + (date - 1) * 100;
    }
}
