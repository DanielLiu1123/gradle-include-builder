package git;

import io.github.danielliu1123.httpexchange.EnableExchangeClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@SpringBootApplication
@EnableExchangeClients
public class GitApp {

    public static void main(String[] args) {
        SpringApplication.run(GitApp.class, args);
    }

    @HttpExchange("https://my-json-server.typicode.com")
    interface PostApi {
        record Post(Integer id, String title) {
        }

        @GetExchange("/typicode/demo/posts")
        List<Post> list();
    }

}
