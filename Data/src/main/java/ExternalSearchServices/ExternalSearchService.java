package ExternalSearchServices;

public interface ExternalSearchService {

    String searchTerm(String term) throws Exception;
    String getSource();
}
