package git;


import com.google.gson.Gson;

import java.util.Map;

public class DirApp {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson(Map.of("message", "Hello, World!"));
        System.out.println(json);
    }
}
