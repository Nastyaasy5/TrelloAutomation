package api;

import helpers.RandomHelper;
import okhttp3.*;

import java.io.IOException;

public class TrelloApi {

    public static final String KEY = "a6bda45caa5a4fbf859427fa94e28793";
    public static final String TOKEN = "f7af9f83770d3052fc7ef49b584a1e77f1a67f6dda9745a9b8eadc2d83701daa";
    RandomHelper rH = new RandomHelper();

    OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String delete(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).delete(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String createBoard(String boardName) throws IOException {
        String url = "https://api.trello.com/1/boards?name=" + boardName +
                "&key=" + KEY + "&token=" + TOKEN;
        String json = "{\n" +
                "\"name\":\"" + boardName + "\"\n" +
                "}";
        String response = post(url, json);
        return response;
    }

    public String deleteBoard(String boardId) throws IOException {
        String url = "https://api.trello.com/1/boards/" + boardId +
                "?key=" + KEY + "&token=" + TOKEN;
        String json = "{\n" +
                "\"id\":\"" + boardId + "\"\n" +
                "}";
        String response = delete(url, json);
        return response;
    }


}
