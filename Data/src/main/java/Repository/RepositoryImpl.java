package Repository;

import DataBase.DataBase;
import DataEntities.DataSearchResult.DataSearchResult;
import DataEntities.DataSearchResult.DataSearchResultFactory;
import Entities.SearchResult.SearchResult;
import ExternalSearchServices.ExternalSearchService;
import ExternalSearchServices.ExternalSearchServicesList;
import ModelAdapters.DataSearchResultAdapter.DataSearchResultAdapter;
import UseCases.ErrorHandler;
import UseCases.Repository;
import java.util.LinkedList;
import java.util.List;

class RepositoryImpl implements Repository {

    private DataBase dataBase;
    private DataSearchResultAdapter dataSearchResultAdapter;
    private ExternalSearchServicesList externalSearchServicesList;
    private ErrorHandler errorHandler;
    private final String NO_RESULTS_FOUND = "No result";

    RepositoryImpl(DataBase dataBase, DataSearchResultAdapter dataSearchResultAdapter, ErrorHandler errorHandler, ExternalSearchServicesList externalSearchServicesList) {
        this.dataBase = dataBase;
        this.dataSearchResultAdapter = dataSearchResultAdapter;
        this.errorHandler = errorHandler;
        this.externalSearchServicesList = externalSearchServicesList;
    }

    public List<SearchResult> searchTerm(String term) {
        DataSearchResult datasearchResult = null;
        List<DataSearchResult> dataSearchResultList = new LinkedList<>();
        for (ExternalSearchService externalSearchService : externalSearchServicesList.getExternalSearchServices()) {
            String searchSource = "";
            try {
                searchSource = externalSearchService.getSource();
                datasearchResult = dataBase.searchTerm(term, searchSource);
                if (datasearchResult == null) {
                    String result = externalSearchService.searchTerm(term);
                    if (termFound(result)) {
                        datasearchResult = makeSearchResult(term, result, searchSource);
                        saveInDb(datasearchResult);
                    } else {
                        datasearchResult = makeNoResultsFoundResult(term, searchSource);
                    }
                }
            } catch (Exception exception) {
                errorHandler.addError(searchSource, exception);
            }
            if (datasearchResult != null) {
                datasearchResult.setSearchResultTerm(term);
                dataSearchResultList.add(datasearchResult);
            }
        }
        List<SearchResult> modelSearchResultList = adaptToModelSearchResult(dataSearchResultList);
        return modelSearchResultList;
    }

    private boolean termFound(String searchResult) {
        return !searchResult.isEmpty();
    }

    private DataSearchResult makeSearchResult(String term, String searchServiceResultString, String searchSource) {
        return DataSearchResultFactory.makeSearchResult(term, searchServiceResultString , searchSource);
    }

    private DataSearchResult makeNoResultsFoundResult(String term, String searchSource) {
        String result = NO_RESULTS_FOUND;
        return DataSearchResultFactory.makeSearchResult(term, result, searchSource);
    }

    private void saveInDb(DataSearchResult dataSearchResult) {
        dataBase.saveTerm(dataSearchResult);
    }

    private List<SearchResult> adaptToModelSearchResult(List<DataSearchResult> dataSearchResultList) {
        List<SearchResult> modelSearchResultList = new LinkedList<>();
        for(DataSearchResult dataSearchResult : dataSearchResultList) {
            SearchResult modelSearchResult = dataSearchResultAdapter.adaptToModelSearchResult(dataSearchResult);
            modelSearchResultList.add(modelSearchResult);
        }
        return modelSearchResultList;
    }
}
