package Repository;

import DataBase.DataBaseModule;
import ErrorHandler.ErrorHandlerModule;
import ExternalSearchServices.ExternalServicesSetModule;
import ModelAdapters.DataSearchResultAdapter.DataSearchResultAdapterModule;
import UseCases.Repository;

public class RepositoryModule {

    private static RepositoryModule instance;
    private Repository repository;

    private RepositoryModule() {
        repository = new RepositoryImpl(
                DataBaseModule.getInstance().getDataBase(),
                DataSearchResultAdapterModule.getInstance().getDataSearchResultAdapter(),
                ErrorHandlerModule.getInstance().getErrorHandler(),
                ExternalServicesSetModule.getInstance().getExternalSearchServicesList()
        );
    }

    public static RepositoryModule getInstance() {
        if(instance == null)
            instance = new RepositoryModule();
        return instance;
    }

    public Repository getRepository() {
        return repository;
    }
}