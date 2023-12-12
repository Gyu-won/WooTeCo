package menu.domain.entity;

import menu.domain.RandomGenerator;

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
        Category selectedCategory = findByIndex(selectedIndex);
        selectedCategory.selectedCount += 1;
        if (selectedCategory.selectedCount > 2) {
            selectedCategory.selectedCount -= 1;
            return Category.validate(RandomGenerator.selectCategory());
        }
        return selectedCategory;
    }

    private static Category findByIndex(Integer index) {
        for (Category category : Category.values()) {
            if (category.index.equals(index)) {
                return category;
            }
        }
        throw new IllegalArgumentException("해당하는 카테고리는 없습니다.");
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }
}
