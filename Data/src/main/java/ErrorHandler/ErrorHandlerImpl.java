package ErrorHandler;

import DataEntities.DataSearchError.DataSearchError;
import DataEntities.DataSearchError.DataSearchErrorFactory;
import Entities.SearchError.SearchError;
import ModelAdapters.DataSearchErrorAdapter.DataSearchErrorAdapter;
import UseCases.ErrorHandler;
import java.util.LinkedList;
import java.util.List;

class ErrorHandlerImpl implements ErrorHandler {

    private List<DataSearchError> searchErrorsList;
    private DataSearchErrorAdapter dataSearchErrorAdapter;

    ErrorHandlerImpl(DataSearchErrorAdapter dataSearchErrorAdapter) {
        this.dataSearchErrorAdapter = dataSearchErrorAdapter;
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
            SearchError modelSearchError = dataSearchErrorAdapter.adaptToModelSearchError(dataSearchError);
            modelSearchErrorList.add(modelSearchError);
        }
        return modelSearchErrorList;
    }

    public void clearErrors() {
        searchErrorsList.clear();
    }
}
