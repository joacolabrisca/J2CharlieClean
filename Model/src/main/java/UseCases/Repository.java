package UseCases;

import Entities.SearchResult.SearchResult;
import java.util.List;

public interface Repository {

    List<SearchResult> searchTerm(String term);
}
