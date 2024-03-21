package git;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static git.GitApp.PostApi;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GitAppTest {

    @Autowired
    PostApi postApi;

    @Test
    void testPostApi() {
        assertThat(postApi.list()).isNotEmpty();
    }

}
