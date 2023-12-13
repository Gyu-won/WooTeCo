package bridge.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {

    private final Map<Integer, String> result = new HashMap<>();

    public void add(Integer currentLocation, String block) {
        result.put(currentLocation, block);
    }
}
