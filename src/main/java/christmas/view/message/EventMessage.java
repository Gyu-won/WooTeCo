package christmas.view.message;

public enum EventMessage {
    PREVIEW("12월 {date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    private final String template;

    EventMessage(String template) {
        this.template = template;
    }

    public String getMessage(Integer visitDate) {
        return template.replace("{date}", Integer.toString(visitDate));
    }
}
