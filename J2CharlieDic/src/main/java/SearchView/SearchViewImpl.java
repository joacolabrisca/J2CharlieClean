package SearchView;

import Controller.ViewController;
import GUI.Window;
import ViewEntities.ViewSearchError.ViewSearchError;
import ViewEntities.ViewSearchResult.ViewSearchResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class SearchViewImpl implements SearchView {

    private ViewController viewController;
    private Window window;

    SearchViewImpl(ViewController viewController) {
        this.viewController = viewController;
        window = new Window();
        initButtonListener();
    }

    private void initButtonListener() {
        window.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String term = getWindowTextField();
                performSearch(term);
            }
        });
    }

    private String getWindowTextField() {
        String term = window.getTextFieldText();
        return term;
    }

    private void performSearch(String term) {
        viewController.performSearch(term);
        window.startProgress();
    }

    public void showSearchResults(List<ViewSearchResult> viewSearchResultList) {
        window.stopProgress();
        String textToPanel = extractSearchResultData(viewSearchResultList);
        window.setTexToJTextPane(textToPanel);
    }

    private String extractSearchResultData(List<ViewSearchResult> viewSearchResultList) {
        String searchResultData = "";
        for(ViewSearchResult viewSearchResult : viewSearchResultList) {
            searchResultData += StringFormatHandler.extractSearchResultData(viewSearchResult);
        }
        return searchResultData;
    }

    public void showSearchErrors(List<ViewSearchError> viewSearchErrorList) {
        window.stopProgress();
        for(ViewSearchError viewSearchError : viewSearchErrorList) {
            window.showError(viewSearchError.getErrorSource(), viewSearchError.getErrorText());
        }
    }
}
