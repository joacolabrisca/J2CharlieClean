package ExternalSearchServices;

import java.util.List;

class ExternalServicesListImpl implements ExternalSearchServicesList {

    private ExternalServicesFactory externalServicesFactory;

    public ExternalServicesListImpl(ExternalServicesFactory externalServicesFactory) {
        this.externalServicesFactory = externalServicesFactory;
    }

    public List<ExternalSearchService> getExternalSearchServices() {
        return externalServicesFactory.getExternalSearchServices();
    }
}
