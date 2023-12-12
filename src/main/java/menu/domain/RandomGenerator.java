package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static Integer selectCategory() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
