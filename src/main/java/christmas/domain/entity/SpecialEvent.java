package christmas.domain.entity;

public class SpecialEvent {
    public static int apply(VisitDate visitDate) {
        int date = visitDate.getVisitDate();
        if (date == 25 || date % 7 == 3) {
            return 1000;
        }
        return 0;
    }
}
