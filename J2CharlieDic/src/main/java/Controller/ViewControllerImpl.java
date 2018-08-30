package Controller;

import UseCases.SearchTerm.SearchErrorListener;
import UseCases.SearchTerm.SearchTermListener;
import UseCases.SearchTerm.SearchTermUseCase;
import Entities.SearchError.SearchError;
import Entities.SearchResult.SearchResult;
import ModelAdapters.ViewSearchErrorAdapter.ViewSearchErrorAdapter;
import ModelAdapters.ViewSearchResultAdapter.ViewSearchResultAdapter;
import SearchView.SearchViewModule;
import SearchView.SearchView;
import ViewEntities.ViewSearchError.ViewSearchError;
import ViewEntities.ViewSearchResult.ViewSearchResult;

import java.util.LinkedList;
import java.util.List;

class ViewControllerImpl implements ViewController {

    private SearchTermUseCase searchTermUseCase;
    private ViewSearchResultAdapter viewSearchResultAdapter;
    private ViewSearchErrorAdapter viewSearchErrorAdapter;
    private SearchView searchView;

    ViewControllerImpl(SearchTermUseCase searchTermUseCase, ViewSearchResultAdapter viewSearchResultAdapter, ViewSearchErrorAdapter viewSearchErrorAdapter) {
        this.searchTermUseCase = searchTermUseCase;
        this.viewSearchResultAdapter = viewSearchResultAdapter;
        this.viewSearchErrorAdapter = viewSearchErrorAdapter;
    }

    public void initView() {
        getSearchView();
        initListeners();
    }

    private void getSearchView() {
        searchView = SearchViewModule.getInstance().openDictionaryFrame(this);
    }

    private void initListeners() {

        searchTermUseCase.setSearchListener(new SearchTermListener() {
            @Override
            public void searchCompleted(List<SearchResult> searchResultList) {
                showSearchResults(searchResultList);
            }
        });

        searchTermUseCase.setSearchErrorListener(new SearchErrorListener() {
            @Override
            public void searchError(List<SearchError> searchErrorList) {
                showSearchErrors(searchErrorList);
            }
        });
    }

    private void showSearchResults(List<SearchResult> searchResultList) {
        List<ViewSearchResult> viewSearchResultList = adaptSearchResultListToViewSearchResultList(searchResultList);
        searchView.showSearchResults(viewSearchResultList);
    }

    private List<ViewSearchResult> adaptSearchResultListToViewSearchResultList(List<SearchResult> searchResultList) {
        List<ViewSearchResult> viewSearchResultList = new LinkedList<>();
        for(SearchResult modelSearchResult : searchResultList) {
            ViewSearchResult viewSearchResult = viewSearchResultAdapter.adaptFromModelSearchResult(modelSearchResult);
            viewSearchResultList.add(viewSearchResult);
        }
        return viewSearchResultList;
    }

    private void showSearchErrors(List<SearchError> searchErrorList) {
        List<ViewSearchError> viewSearchErrorList = adaptSearchErrorsListToViewSearchErrorList(searchErrorList);
        searchView.showSearchErrors(viewSearchErrorList);
    }

    private List<ViewSearchError> adaptSearchErrorsListToViewSearchErrorList(List<SearchError> searchErrorList) {
        List<ViewSearchError> viewSearchErrorList = new LinkedList<>();
        for(SearchError modelSearchError : searchErrorList) {
            ViewSearchError viewSearchError = viewSearchErrorAdapter.adaptFromModelSearchError(modelSearchError);
            viewSearchErrorList.add(viewSearchError);
        }
        return viewSearchErrorList;
    }

    public void performSearch(String term) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchTermUseCase.searchTerm(term);
            }
        }).start();
    }
}
