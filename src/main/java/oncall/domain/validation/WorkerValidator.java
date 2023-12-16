package oncall.domain.validation;

import java.util.Arrays;
import java.util.List;

public class WorkerValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static List<String> validateAndReturn(String workerName) {
        List<String> workerNames = splitWorkerName(workerName);
        return workerNames;
    }

    private static List<String> splitWorkerName(String workerName) {
        return Arrays.asList(workerName.split(DELIMITER, SPLIT_LIMIT));
    }
}
