package christmas.domain.entity;

import java.util.List;

public class TotalEventReward {
    private final List<Integer> totalEventReward;

    private TotalEventReward(List<Integer> totalEventReward) {
        this.totalEventReward = totalEventReward;
    }

    public static TotalEventReward create(List<Integer> totalEventReward) {
        return new TotalEventReward(totalEventReward);
    }

    public Integer sumEventDiscounts() {
        return totalEventReward.stream().mapToInt(Integer::intValue).sum();
    }
}
