package UseCases.SearchTerm;

public interface SearchTermUseCase {

    void searchTerm(String term);
    void setSearchListener(SearchTermListener searchTermListener);
    void setSearchErrorListener(SearchErrorListener searchErrorListener);
}
