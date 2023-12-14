package christmas.domain.entity;

public class Badge {
    private static final String SANTA = "산타";
    private static final String TREE = "트리";
    private static final String STAR = "별";
    private static final String NOTHING = "없음";
    private static final Integer PRICE_FOR_SANTA = 20000;
    private static final Integer PRICE_FOR_TREE = 10000;
    private static final Integer PRICE_FOR_STAR = 5000;

    private final String badge;

    public Badge(Integer totalDiscountPrice) {
        badge = createBadge(totalDiscountPrice);
    }

    private String createBadge(Integer totalDiscountPrice) {
        if (totalDiscountPrice >= PRICE_FOR_SANTA) {
            return SANTA;
        }
        if (totalDiscountPrice >= PRICE_FOR_TREE) {
            return TREE;
        }
        if (totalDiscountPrice >= PRICE_FOR_STAR) {
            return STAR;
        }
        return NOTHING;
    }

    public String getBadge() {
        return badge;
    }
}
