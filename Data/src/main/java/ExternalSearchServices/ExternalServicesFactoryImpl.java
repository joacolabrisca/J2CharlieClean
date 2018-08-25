package ExternalSearchServices;

import ayds.dictionary.WikipediaService.WikipediaService;
import SearchService.SearchService;
import com.example.yandex.service.TranslatorService;

import java.util.LinkedList;
import java.util.List;

class ExternalServicesFactoryImpl implements ExternalServicesFactory {

    List<ExternalSearchService> externalSearchServicesList;

    public ExternalServicesFactoryImpl(WikipediaService wikipediaService, TranslatorService translatorService, SearchService searchService) {

        externalSearchServicesList = new LinkedList<>();

        ExternalSearchService WikipediaAPI = new WikipediaAPIServiceAdapter(wikipediaService);
        externalSearchServicesList.add(WikipediaAPI);

        ExternalSearchService YandexService = new YandexServiceAdapter(translatorService);
        externalSearchServicesList.add(YandexService);

        ExternalSearchService BigHugeLabsLib = new BigHugeLabsLibServiceAdapter(searchService);
        externalSearchServicesList.add(BigHugeLabsLib);
    }

    public List<ExternalSearchService> getExternalSearchServices() {

        return externalSearchServicesList;
    }
}
