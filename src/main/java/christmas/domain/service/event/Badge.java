package christmas.domain.service.event;

public class Badge {
    private static final String NO_BADGE = "없음";
    private static final String STAR = "별";
    private static final String TREE = "트리";

    private static final Integer STAR_MINIMUM = 5000;
    private static final Integer TREE_MINIMUM = 10000;


    public static String calculate(Integer totalEventReward) {
        if (isTree(totalEventReward)) {
            return TREE;
        }
        if (isStar(totalEventReward)) {
            return STAR;
        }
        return NO_BADGE;
    }

    private static boolean isStar(Integer totalEventReward) {
        return totalEventReward >= STAR_MINIMUM;
    }

    private static boolean isTree(Integer totalEventReward) {
        return totalEventReward >= TREE_MINIMUM;
    }
}
