package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task3ToDoShower {
    public static void openTaskShower(int userId) throws IOException, InterruptedException {

        String url = String.format("https://jsonplaceholder.typicode.com/users/%d/todos", userId);
        System.out.println(url);
        Document document = Jsoup.connect(url)
                .ignoreContentType(true)
                .get();

        String body = document.body().text();
        Type type = TypeToken.getParameterized(List.class, ToDo.class).getType();
        List <ToDo> todos = new Gson().fromJson(body, type);
        for (ToDo todo : todos) {
            if(!todo.isCompleted()){
                System.out.println("task id - "
                        + todo.getId() + '\n'
                        +todo.getTitle() + '\n');
            }
        }

//        System.out.println(url);
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(send.statusCode());
//        System.out.println(send.body());
//        Type type = TypeToken.getParameterized(List.class, ToDo.class).getType();
//
//        List<ToDo> toDos = new Gson().fromJson(send.body(),type);
//
//        toDos.stream()
//                .filter(t -> !t.completed)
//                .forEach(t -> {
//                    System.out.println(t.title);
//                });
//

    }
}
