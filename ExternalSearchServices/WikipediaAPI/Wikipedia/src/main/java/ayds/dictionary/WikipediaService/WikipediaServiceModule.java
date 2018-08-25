package ayds.dictionary.WikipediaService;

public class WikipediaServiceModule {

    private static WikipediaServiceModule instance;
    private WikipediaService wikipediaService;

    private WikipediaServiceModule() {

        ResponseFormatParser parser = new ParserFromXML();
        wikipediaService = new WikipediaServiceImp(parser);
    }

    public static WikipediaServiceModule getInstance() {
        if (instance == null) {
            instance = new WikipediaServiceModule();
        }
        return instance;
    }

    public WikipediaService getWikipediaService() {
        return wikipediaService;
    }

}
