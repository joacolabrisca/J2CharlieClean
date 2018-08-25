package com.example.yandex.service;

import com.google.gson.Gson;

public class YandexModule {

    private static final YandexModule ourInstance = new YandexModule();

    private ResultConverter resultConverter;
    private TranslatorService translatorService;
    private YandexApiConnection apiConnection;

    public static YandexModule getInstance() {
        return ourInstance;
    }

    private YandexModule() {
        initServices();
    }

    private void initServices(){
        resultConverter = new JsonToStringConverter(new Gson());
        apiConnection = new YandexApiConnection();
        conectarApi();
        translatorService = new TranslatorServiceImpl(apiConnection.getYandex(),resultConverter);
    }

    private void conectarApi(){
        apiConnection.connectAPI();
    }

    public TranslatorService getTranslatorService(){
        return translatorService;
    }
}
