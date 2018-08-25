package DataBase;

public class DataBaseModule {

    private static DataBaseModule instance;
    private DataBase dataBase;

    private DataBaseModule() {
        dataBase = new DataBaseImpl();
    }

    public static DataBaseModule getInstance() {
        if(instance == null)
            instance = new DataBaseModule();
        return instance;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}