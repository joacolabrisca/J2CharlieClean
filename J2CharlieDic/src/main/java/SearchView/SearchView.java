package SearchView;

import Entities.SearchError.SearchError;
import Entities.SearchResult.SearchResult;
import UseCases.SearchTerm.SearchErrorListener;
import UseCases.SearchTerm.SearchTermListener;
import UseCases.SearchTerm.SearchTermUseCase;
import GUI.Window;
import ModelAdapters.ViewSearchErrorAdapter.ViewSearchErrorAdapter;
import ModelAdapters.ViewSearchResultAdapter.ViewSearchResultAdapter;
import ViewEntities.ViewSearchError.ViewSearchError;
import ViewEntities.ViewSearchResult.ViewSearchResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class SearchView {

    private SearchTermUseCase searchTermUseCase;
    private ViewSearchResultAdapter viewSearchResultAdapter;
    private ViewSearchErrorAdapter viewSearchErrorAdapter;
    private Window window;

    SearchView(SearchTermUseCase searchTermUseCase, ViewSearchResultAdapter viewSearchResultAdapter, ViewSearchErrorAdapter viewSearchErrorAdapter) {
        this.searchTermUseCase = searchTermUseCase;
        this.viewSearchResultAdapter = viewSearchResultAdapter;
        this.viewSearchErrorAdapter = viewSearchErrorAdapter;
        window = new Window();
        initListeners();
    }

    private void initListeners() {
        window.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String term = getWindowTextField();
                performSearch(term);
            }
        });

        searchTermUseCase.setSearchListener(new SearchTermListener() {
            @Override
            public void searchCompleted(List<SearchResult> searchResultList) {
                window.stopProgress();
                showSearchResults(searchResultList);
            }
        });

        searchTermUseCase.setSearchErrorListener(new SearchErrorListener() {
            @Override
            public void searchError(List<SearchError> searchErrorList) {
                window.stopProgress();
                showSearchErrors(searchErrorList);
            }
        });
    }

    private String getWindowTextField() {
        String term = window.getTextFieldText();
        return term;
    }

    private void performSearch(String term) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchTermUseCase.searchTerm(term);
            }
        }).start();
        window.startProgress();
    }

    private void showSearchResults(List<SearchResult> SearchResultList) {
        String textToPanel = "";
        for(SearchResult modelSearchResult : SearchResultList) {
            ViewSearchResult viewSearchResult = viewSearchResultAdapter.adaptFromModelSearchResult(modelSearchResult);
            textToPanel += StringFormatHandler.extractSearchResultData(viewSearchResult);
        }
        window.setTexToJTextPane(textToPanel);
    }

    private void showSearchErrors(List<SearchError> searchErrorList) {
        for(SearchError modelSearchError : searchErrorList) {
            ViewSearchError viewSearchError = viewSearchErrorAdapter.adaptFromModelSearchError(modelSearchError);
            window.showError(viewSearchError.getErrorSource(), viewSearchError.getErrorText());
        }
    }
}
