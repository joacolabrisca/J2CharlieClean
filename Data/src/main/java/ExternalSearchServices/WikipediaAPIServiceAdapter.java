package ExternalSearchServices;

import ayds.dictionary.WikipediaService.WikipediaService;

import java.io.IOException;

class WikipediaAPIServiceAdapter implements ExternalSearchService {

    private WikipediaService wikipediaService;
    private final String source = "WIKIPEDIA";

    public WikipediaAPIServiceAdapter(WikipediaService wikipediaService) {
        this.wikipediaService = wikipediaService;
    }

    public String searchTerm(String term) throws IOException {
        
        String searchResult = wikipediaService.getMeaning(term);

        return searchResult;
    }

    public String getSource() {
        return source;
    }
}
