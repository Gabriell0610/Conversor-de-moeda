import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetApi {

    public Coins dataApi(String sigla) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/e3eb4683ec3fd1c33f0ed95a/latest/" + sigla))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           return new Gson().fromJson(response.body(), Coins.class);
        }catch (IOException | InterruptedException e ) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
