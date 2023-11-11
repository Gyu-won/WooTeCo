package christmas.domain.entity;

import java.util.List;

public class EventReward {
    private final List<Integer> totalEventReward;

    private EventReward(List<Integer> totalEventReward) {
        this.totalEventReward = totalEventReward;
    }

    public static EventReward create(List<Integer> totalEventReward) {
        return new EventReward(totalEventReward);
    }

    public Integer sumEventDiscounts() {
        return totalEventReward.stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> getTotalEventReward() {
        return totalEventReward;
    }
}
