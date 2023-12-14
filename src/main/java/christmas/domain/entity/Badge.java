package christmas.domain.entity;

public class Badge {
    private static final String SANTA = "산타";
    private static final String TREE = "트리";
    private static final String STAR = "별";
    private static final String NOTHING = "없음";

    private final String badge;

    public Badge(Integer totalDiscountPrice) {
        badge = createBadge(totalDiscountPrice);
    }

    private String createBadge(Integer totalDiscountPrice) {
        if (totalDiscountPrice >= 20000) {
            return SANTA;
        }
        if (totalDiscountPrice >= 10000) {
            return TREE;
        }
        if (totalDiscountPrice >= 5000) {
            return STAR;
        }
        return NOTHING;
    }

    public String getBadge() {
        return badge;
    }
}
