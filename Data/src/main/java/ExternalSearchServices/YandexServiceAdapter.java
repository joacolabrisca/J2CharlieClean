package ExternalSearchServices;

import com.example.yandex.service.TranslatorService;

class YandexServiceAdapter implements ExternalSearchService {

    private TranslatorService translatorService;
    private final String source = "YANDEX";

    YandexServiceAdapter(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    public String searchTerm(String term) throws Exception {
        String SearchResult = translatorService.callCreateTranslatedWord(term);
        return SearchResult;
    }

    public String getSource() {
        return source;
    }
}
