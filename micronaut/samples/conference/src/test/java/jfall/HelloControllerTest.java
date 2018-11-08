package jfall;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloControllerTest {

    private static EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);
    private static RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL());

    @BeforeClass
    public static void startServer() {
        server.start();
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) { server.stop(); }
        if (client != null) { client.stop(); }
    }

    @Test
    public void testIndex() {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/hello").status());
    }

    @Test
    public void testReactive() {
        String response = client.toBlocking().retrieve("/hello/reactive");
        assertTrue(response.startsWith("Hello Reactive JFall!"));
    }

    @Test
    public void testMessage() {
        HttpResponse<Message> response = client.toBlocking().exchange(HttpRequest.GET("/hello/message"), Message.class);
        assertEquals("Message with Hello JFall!", response.body().getText());
    }
}
