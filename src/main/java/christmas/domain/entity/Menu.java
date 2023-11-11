package christmas.domain.entity;

public enum Menu {
    MushroomSoup("양송이수프", "애피타이저", 6000),
    Tapas("타파스", "애피타이저", 5500),
    CaesarSalad("시저샐러드", "애피타이저", 8000),
    TBoneSteak("티본스테이크", "메인", 55000),
    BarbecueRibs("바비큐립", "메인", 54000),
    SeafoodPasta("해산물파스타", "메인", 35000),
    ChristmasPasta("크리스마스파스타", "메인", 25000),
    ChocolateCake("초코케이크", "디저트", 15000),
    IceCream("아이스크림", "디저트", 5000),
    ZeroCoke("제로콜라", "음료", 3000),
    RedWine("레드와인", "음료", 60000),
    Champagne("샴페인", "음료", 25000);

    private final String name;
    private final String category;
    private final Integer price;

    Menu(String name, String category, Integer price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Integer calculateGiftPrice() {
        return Menu.Champagne.price;
    }

    public boolean isDessert() {
        return this.category.equals("디저트");
    }

    public boolean isMain() {
        return this.category.equals("메인");
    }

    public Integer getPrice() {
        return this.price;
    }

    public boolean isSame(String menuName) {
        return this.name.equals(menuName);
    }

}