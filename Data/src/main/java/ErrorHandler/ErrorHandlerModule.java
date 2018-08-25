package ErrorHandler;

import UseCases.ErrorHandler;
import ModelAdapters.DataSearchErrorAdapter.DataSearchErrorAdapterModule;

public class ErrorHandlerModule {

    private static ErrorHandlerModule instance;
    private ErrorHandler errorHandler;

    private ErrorHandlerModule() {
        errorHandler = new ErrorHandlerImpl(DataSearchErrorAdapterModule.getInstance().getDataSearchResultAdapter());
    }

    public static ErrorHandlerModule getInstance() {
        if(instance == null)
            instance = new ErrorHandlerModule();
        return instance;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }
}
