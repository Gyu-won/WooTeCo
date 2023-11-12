package christmas.domain.service.event;

public class Badge {
    private static final String NO_BADGE = "없음";
    private static final String STAR = "별";
    private static final Integer STAR_MINIMUM = 5000;

    public static String calculate(Integer totalEventReward) {
        if (isStar(totalEventReward)) {
            return STAR;
        }
        return NO_BADGE;
    }

    private static boolean isStar(Integer totalEventReward) {
        return totalEventReward >= STAR_MINIMUM;
    }
}
