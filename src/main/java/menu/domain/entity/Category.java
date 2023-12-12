package menu.domain.entity;

public enum Category {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    EUROPE("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
