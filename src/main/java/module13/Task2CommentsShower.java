package module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.List;

public class Task2CommentsShower {
    private final static String url = "https://jsonplaceholder.typicode.com/users/?/posts";
    private final static HttpClient client = HttpClient.newHttpClient();

    private  final static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    private static int getLastUserPost(User user) throws IOException, InterruptedException {
        String postsUrl = url.replace("?", String.valueOf(user.getId()));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postsUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken.getParameterized(List.class, Post.class).getType();

        List<Post> list = gson.fromJson(response.body(), type);
        list.sort(Comparator.comparingInt(u -> u.id));
        if (list.isEmpty()) return -1;
        return list.get(list.size()-1).id;

    }

    public static void commentsToLastUserPost(User user) throws IOException, InterruptedException {
        if(getLastUserPost(user) == -1) {
            System.out.println("Юзера з таким id не існує, або він не має жодного поста." +
                    "\nПеревірте правильніть введених даних");
            return;
        }
        String commentUrl = url.replace("users/?/", "")
                + "/" + getLastUserPost(user)
                + "/comments";
        System.out.println(commentUrl);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(commentUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken.getParameterized(List.class, Comment.class).getType();
        String fileName = String.format("./src/main/java/module13/output_files/user-%d-post-%d-comments.json", user.getId(), getLastUserPost(user));

        FileWriter fw = new FileWriter(fileName);
        fw.write(response.body());
        fw.close();

        List<Comment> list = gson.fromJson(response.body(), type);
        for (Comment comment : list) {
            System.out.println("comment id - "
                    + comment.getId()
                    + '\n'
                    + comment.getBody()
                    +'\n');
        }

    }
}
