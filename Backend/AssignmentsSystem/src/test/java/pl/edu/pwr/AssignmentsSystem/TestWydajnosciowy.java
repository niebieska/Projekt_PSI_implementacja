package pl.edu.pwr.AssignmentsSystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class TestWydajnosciowy {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();

    private ThreadLocal threadLocal = new ThreadLocal();

    @Test
    public void test200Users() throws Exception {
        List<Thread> threads = new ArrayList<>();
        List<Long> times = new ArrayList<>();
        for (int i = 0; i < 200; i++)
        {
            Thread T1 = new Thread(() -> {

                threadLocal.set(System.currentTimeMillis());
                restTemplate.getForObject(
                        createURLWithPort("/getAllIdentyfikatoryPlanuStudiow"), List.class);
                times.add(System.currentTimeMillis() - (Long)threadLocal.get());
                System.out.println("It takes " + (System.currentTimeMillis() - (Long)threadLocal.get()) + " miliseconds");
            });
            T1.start();
            threads.add(T1);
        }

        for (int i = 0; i < threads.size(); i++)
        {
            threads.get(i).join();
        }
        Assert.assertTrue(times.stream().max(Comparator.naturalOrder()).get() < 5000);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
