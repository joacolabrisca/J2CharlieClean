package UseCases.SearchTerm;

import Entities.SearchResult.SearchResult;

import java.util.List;

public interface SearchTermListener {

    void searchCompleted(List<SearchResult> searchResultList);
}
