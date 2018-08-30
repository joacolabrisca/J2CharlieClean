package MainModule;

import Controller.ViewController;
import Controller.ViewControllerModule;
import ErrorHandler.ErrorHandlerModule;
import Repository.RepositoryModule;
import UseCases.ErrorHandler;
import UseCases.Repository;

class Configuration {

    static void startApplication() {
        Repository repository = getRepository();
        ErrorHandler errorHandler = getErrorHandler();
        ViewController viewController = ViewControllerModule.getInstance().getViewController(repository, errorHandler);
        viewController.initView();
    }

    private static Repository getRepository() {
        Repository repository = RepositoryModule.getInstance().getRepository();
        return repository;
    }

    private static ErrorHandler getErrorHandler() {
        ErrorHandler errorHandler = ErrorHandlerModule.getInstance().getErrorHandler();
        return errorHandler;
    }
}
