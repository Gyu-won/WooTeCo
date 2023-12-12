package menu.domain.entity;

import menu.view.message.Error;

public enum Menu {
    JAPENESE1("규동", Category.JAPANESE),
    JAPENESE2("우동", Category.JAPANESE),
    JAPENESE3("미소시루", Category.JAPANESE),
    JAPENESE4("스시", Category.JAPANESE),
    JAPENESE5("가츠동", Category.JAPANESE),
    JAPENESE6("오니기리", Category.JAPANESE),
    JAPENESE7("하이라이스", Category.JAPANESE),
    JAPENESE8("라멘", Category.JAPANESE),
    JAPENESE9("오코노미야끼", Category.JAPANESE),
    KOREAN1("김밥", Category.KOREAN),
    KOREAN2("김치찌개", Category.KOREAN),
    KOREAN3("쌈밥", Category.KOREAN),
    KOREAN4("된장찌개", Category.KOREAN),
    KOREAN5("비빔밥", Category.KOREAN),
    KOREAN6("칼국수", Category.KOREAN),
    KOREAN7("불고기", Category.KOREAN),
    KOREAN8("떡볶이", Category.KOREAN),
    KOREAN9("제육볶음", Category.KOREAN),
    CHINESE1("깐풍기", Category.CHINESE),
    CHINESE2("볶음면", Category.CHINESE),
    CHINESE3("동파육", Category.CHINESE),
    CHINESE4("짜장면", Category.CHINESE),
    CHINESE5("짬뽕", Category.CHINESE),
    CHINESE6("마파두부", Category.CHINESE),
    CHINESE7("탕수육", Category.CHINESE),
    CHINESE8("토마토 달걀볶음", Category.CHINESE),
    CHINESE9("고추잡채", Category.CHINESE),
    ASIAN1("팟타이", Category.ASIAN),
    ASIAN2("카오 팟", Category.ASIAN),
    ASIAN3("나시고렝", Category.ASIAN),
    ASIAN4("파인애플 볶음밥", Category.ASIAN),
    ASIAN5("쌀국수", Category.ASIAN),
    ASIAN6("똠양꿍", Category.ASIAN),
    ASIAN7("반미", Category.ASIAN),
    ASIAN8("월남쌈", Category.ASIAN),
    ASIAN9("분짜", Category.ASIAN),
    EUROPE1("라자냐", Category.EUROPE),
    EUROPE2("그라탱", Category.EUROPE),
    EUROPE3("뇨끼", Category.EUROPE),
    EUROPE4("끼슈", Category.EUROPE),
    EUROPE5("프렌치 토스트", Category.EUROPE),
    EUROPE6("바게트", Category.EUROPE),
    EUROPE7("스파게티", Category.EUROPE),
    EUROPE8("피자", Category.EUROPE),
    EUROPE9("파니니", Category.EUROPE);


    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static boolean isContain(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(menuName)) {
                return true;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_MENU_NAME.getMessage());
    }

    public static Menu findByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_MENU_NAME.getMessage());
    }
}
