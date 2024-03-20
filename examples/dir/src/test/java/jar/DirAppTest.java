package jar;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DirAppTest {

    @Test
    void testGsonPresent() {
        Gson gson = new Gson();
        String json = gson.toJson(Map.of("message", "Hello, World!"));

        assertThat(json).isEqualTo("{\"message\":\"Hello, World!\"}");
    }

}
