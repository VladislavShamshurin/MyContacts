package contacts;

public final class RegexContact {
    public static final String firstRegexNumber = "\\+?\\d?\\s?[\\s\\(]\\d{2,8}[\\s\\)][\\s\\-]\\d{2,8}[\\s\\-]\\d{2,8}[\\s\\-]\\w{1,8}";
    public static final String secondRegexNumber = "\\+?\\(?\\w{1,8}\\)?[\\s\\-]?((\\w{1,8}))?[\\s\\-]?((\\w{1,8}))?[\\s\\-]?((\\w{1,8}))?";
    public static final String thirdRegexNumber = "\\+?\\w{1,8}?[\\s\\-]?\\(?((\\w{1,8}))\\)??[\\s\\-]?((\\w{1,8}))?[\\s\\-]?((\\w{1,8}))?";
}
