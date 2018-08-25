package ExternalSearchServices;

import SearchService.SearchServiceModule;
import ayds.dictionary.WikipediaService.WikipediaServiceModule;
import com.example.yandex.service.YandexModule;

public class ExternalServicesSetModule {

    private ExternalSearchServicesList externalSearchServicesList;
    private static ExternalServicesSetModule instance;

    private ExternalServicesSetModule() {

        ExternalServicesFactory externalServicesFactory = new ExternalServicesFactoryImpl(

                WikipediaServiceModule.getInstance().getWikipediaService(),
                YandexModule.getInstance().getTranslatorService(),
                SearchServiceModule.getInstance().getSearchService()

        );
        externalSearchServicesList = new ExternalServicesListImpl(externalServicesFactory);
    }

    public static ExternalServicesSetModule getInstance() {
        if(instance == null)
            instance = new ExternalServicesSetModule();
        return instance;
    }

    public ExternalSearchServicesList getExternalSearchServicesList() {
        return externalSearchServicesList;
    }
}
