package christmas.domain.entity;

import java.util.Map;
import java.util.Map.Entry;

public class DayEvent {
    public static boolean applicableHolidayEvent(VisitDate visitDate) {
        int weekday = visitDate.getVisitDate() % 7;
        return weekday == 1 || weekday == 2;
    }

    public static Integer applyHoliday() {
        return 1;
    }

    public static Integer applyWeekday(Order order) {
        int totalDiscount = 0;
        Map<String, Integer> orders = order.getOrder();
        for (Entry<String, Integer> entry : order.getOrder().entrySet()) {
            if (Menu.isDessert(entry.getKey())) {
                totalDiscount += 2023 * entry.getValue();
            }
        }
        return totalDiscount;
    }
}
