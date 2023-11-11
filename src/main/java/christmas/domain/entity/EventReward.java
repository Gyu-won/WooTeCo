package christmas.domain.entity;

import java.util.List;

public class EventReward {
    private final List<Integer> eventRewards;

    private EventReward(List<Integer> eventRewards) {
        this.eventRewards = eventRewards;
    }

    public static EventReward create(List<Integer> eventRewards) {
        return new EventReward(eventRewards);
    }

    public Integer sumEventRewards() {
        return eventRewards.stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> getEventRewards() {
        return eventRewards;
    }
}
