package SearchService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import retrofit2.Response;

class SearchServiceStringConverterImpl implements SearchServiceStringConverter {

    public StringBuilder responseToString(Response<String> wikiResult) {
        JsonObject jObj = makeJsonObject(wikiResult);
        StringBuilder extract = new StringBuilder();
        extract = getNounSynonymous(extract, jObj);
        if(!Empty(extract.toString()))
            extract.append("<br>");
        extract = getVerbSynonymous(extract, jObj);
        return extract;
    }

    private JsonObject makeJsonObject(Response<String> wikiResult){
        Gson gson = new Gson();
        JsonObject jObj = gson.fromJson(wikiResult.body(), JsonObject.class);
        return jObj;
    }

    private StringBuilder getNounSynonymous(StringBuilder extract, JsonObject jObj) {
        if(thereAreSynonymous(jObj.get("noun"))) {
            JsonArray nounsSynonymous = makeJsonArray(jObj, "noun");
            extract.append("<b>" + "noun"  + "s:</b><br>");
            extract = addSynonymous(nounsSynonymous, extract);
            extract.append("<br>");
        }
        return extract;
    }

    private boolean thereAreSynonymous(JsonElement result) {
        return result != null;
    }

    private StringBuilder addSynonymous(JsonArray nounsSynonymous, StringBuilder extract) {
        for (JsonElement element : nounsSynonymous)
            extract.append(element.getAsString()).append(", ");
        return extract;
    }

    private boolean Empty(String extractString) {
        return extractString.isEmpty();
    }

    private StringBuilder getVerbSynonymous(StringBuilder extract, JsonObject jObj) {
        if(thereAreSynonymous(jObj.get("verb"))) {
            JsonArray nounsSynonymous = makeJsonArray(jObj, "verb");
            extract.append("<b>" + "verb"  + "s:</b><br>");
            extract = addSynonymous(nounsSynonymous, extract);
            extract.append("<br>");
        }
        return extract;
    }

    private static JsonArray makeJsonArray(JsonObject jObj, String type) {
        JsonObject noun = jObj.get(type).getAsJsonObject();
        JsonArray nounsSynonymous = noun.get("syn").getAsJsonArray();
        return nounsSynonymous;
    }
}
