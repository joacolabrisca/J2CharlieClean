package ErrorHandler;

import DataEntities.DataSearchError.DataSearchError;
import DataEntities.DataSearchError.DataSearchErrorFactory;
import Entities.SearchError.SearchError;
import Entities.SearchError.SearchErrorFactory;
import ModelAdapters.DataSearchErrorAdapter.DataSearchErrorAdapter;
import UseCases.ErrorHandler;

import java.util.LinkedList;
import java.util.List;

class ErrorHandlerImpl implements ErrorHandler {

    private List<DataSearchError> searchErrorsList;

    public ErrorHandlerImpl(DataSearchErrorAdapter dataSearchErrorAdapter) {
        searchErrorsList = new LinkedList<>();
    }

    public void addError(String source, Exception exception) {
        DataSearchError dataSearchError = DataSearchErrorFactory.makeDataSearchError(source, exception.getMessage());
        searchErrorsList.add(dataSearchError);
    }

    public List<SearchError> getSearchErrors() {
        List<SearchError> modelSearchErrorList = adaptToModelSearchErrors();
        return modelSearchErrorList;
    }

    private List<SearchError> adaptToModelSearchErrors() {
        List<SearchError> modelSearchErrorList = new LinkedList<>();
        for(DataSearchError dataSearchError : searchErrorsList) {
            String searchErrorSource = dataSearchError.getErrorSource();
            String searchErrorString = dataSearchError.getErrorText();
            SearchError modelSearchError = SearchErrorFactory.makeSearchError(searchErrorSource, searchErrorString);
            modelSearchErrorList.add(modelSearchError);
        }
        return modelSearchErrorList;
    }

    public void clearErrors() {
        searchErrorsList.clear();
    }
}
