package DataBase;

class DataBaseStringConverter {

    private static final String FOUND_INDICATOR = "[*] ";

    static String replaceDangerousCharacters(String text) {
        String safeSql = text.replaceAll("'", "`");
        return safeSql;
    }

    static String aggregateFoundIndicator(String retultText) {
        String searchResultTextWithFoundIndicator = FOUND_INDICATOR + retultText;
        return searchResultTextWithFoundIndicator;
    }
}
