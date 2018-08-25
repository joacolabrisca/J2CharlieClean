package SearchView;

import ViewEntities.ViewSearchResult.ViewSearchResult;

class StringFormatHandler {

    private static final String FONT = "arial";

    public static String extractSearchResultData(ViewSearchResult viewSearchResult) {
        String searchResultData = "";
        searchResultData += "<p>";
        searchResultData += getResultSource(viewSearchResult);
        searchResultData += getResultText(viewSearchResult);
        searchResultData += "</p>";
        return searchResultData;
    }

    private static String getResultSource(ViewSearchResult viewSearchResult) {
        String source = "";
        source += "<b>";
        source += viewSearchResult.getSearchResultSource() + ": ";
        source += "</b>";
        return source;
    }

    private static String getResultText(ViewSearchResult viewSearchResult) {
        String text = textToHtml(viewSearchResult.getSearchResultText(), viewSearchResult.getSearchResultSource());
        return text;
    }

    private static String textToHtml(String text, String term) {
        StringBuilder builder = new StringBuilder();
        builder.append("<font face=\"" + FONT + " \">");
        String textWithModifiedApostrophes = modifyApostrophes(text);
        String textInBold = setFontToBold(textWithModifiedApostrophes, term);
        builder.append(textInBold);
        builder.append("</font>");
        return builder.toString();
    }

    private static String modifyApostrophes(String text) {
        return text.replace("'", "`");
    }

    private static String setFontToBold(String text, String term) {
        return text.replace(term, "<b>" + term +"</b>");
    }

}
