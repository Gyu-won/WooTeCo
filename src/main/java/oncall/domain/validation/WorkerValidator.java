package oncall.domain.validation;

import java.util.Arrays;
import java.util.List;
import oncall.view.message.Error;

public class WorkerValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static List<String> validateAndReturn(String workerName) {
        List<String> workerNames = splitWorkerName(workerName);
        checkValidSize(workerNames);
        return workerNames;
    }

    private static void checkValidSize(List<String> workerNames) {
        int workerNumbers = workerNames.size();
        if (workerNumbers < 5 || workerNumbers > 35) {
            throw new IllegalArgumentException(Error.INVALID_WORKER.getMessage());
        }
    }


    private static List<String> splitWorkerName(String workerName) {
        return Arrays.asList(workerName.split(DELIMITER, SPLIT_LIMIT));
    }
}
