package jfall;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        MathClient client = server.getApplicationContext().getBean(MathClient.class);

        assertEquals(client.index().blockingGet(), "math");
        server.stop();
    }
}
