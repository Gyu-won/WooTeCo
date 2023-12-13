package bridge.domain.entity;

public class RetryFlag {
    private static final String RESTART_FLAG = "R";

    private final String retryFlag;

    public RetryFlag(String retryFlag) {
        this.retryFlag = retryFlag;
    }

    public boolean isRetry() {
        return retryFlag.equals(RESTART_FLAG);
    }
}
