package SearchService;

public interface SearchService {

    String searchTerm(String term) throws ServiceNotReachableException;
}