package jfall;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/hello")
public class HelloController {

    private final HelloService helloService;
    private final EmbeddedServer server;

    public HelloController(final HelloService helloService, final EmbeddedServer server) {
        this.helloService = helloService;
        this.server = server;
    }

    @Get(value = "/", produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello JFall !" + Thread.currentThread().getName();
    }

    @Get(value = "/reactive")
    public Single<String> helloReactive() {
        return Single.just("Hello JFall reactive! " + server.getURL());
    }

    @Get("/{name}")
    public Single<Message> helloMessage(String name) {
        return Single.just(new Message(helloService.hello(name)));
    }

    @Get("/events")
    public Publisher<Event<Message>> events() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                       .map(counter -> Event.of(new Message("JFall event!")));
    }
}
