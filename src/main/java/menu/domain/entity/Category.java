package menu.domain.entity;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    EUROPE("양식", 5);

    private final String name;
    private final Integer index;
    private Integer selectedCount;

    Category(String name, Integer index) {
        this.name = name;
        this.index = index;
        selectedCount = 0;
    }

    public static Category validate(Integer selectedIndex) {
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }
}
