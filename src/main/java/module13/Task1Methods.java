package module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task1Methods {
    private final static String url =  "https://jsonplaceholder.typicode.com/users";
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final static HttpClient client = HttpClient.newBuilder().build();
    public static User postUser(User user) throws IOException, InterruptedException {
        String userToJson =  gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(userToJson))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), User.class);
    }

    public static List<User> getUsers() throws IOException {
        Document document = Jsoup.connect(url)
                .ignoreContentType(true)
                .get();

        Type type = TypeToken
                .getParameterized(List.class, User.class)
                .getType();


        return new Gson().fromJson(document.body().text(), type);
    }

    public static User putUser(int userId, User user) throws IOException, InterruptedException {
        String userToUpdate = gson.toJson(user);
        String uri = url +"/" + userId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(userToUpdate))
                .build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(send.body(), User.class);
    }

    public static String deleteUser( User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + user.getId()))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return "statusCode() = " + response.statusCode();
    }

    public static User getUserById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), User.class);
    }


    public static User getUserByUsername(String name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/?username=" + name))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Type type = TypeToken
                .getParameterized(List.class, User.class)
                .getType();
        List <User> users = gson.fromJson(response.body(), type);
        if (users.isEmpty()) return null;
        return users.get(0);
    }
}
