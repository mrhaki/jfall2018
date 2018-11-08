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
    private final EmbeddedServer embeddedServer;

    public HelloController(final HelloService helloService, final EmbeddedServer embeddedServer) {
        this.helloService = helloService;
        this.embeddedServer = embeddedServer;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello JFall! - " + Thread.currentThread().getName();
    }

    @Get(value = "/reactive", produces = MediaType.TEXT_PLAIN)
    public Single<String> helloReactive() {
        return Single.just(String.format("Hello Reactive JFall! - %s on server -> %s",
                                         Thread.currentThread().getName(),
                                         embeddedServer.getURI()));
    }

    @Get("/message")
    public Single<Message> helloMessage() {
        return Single.just(new Message("Message with Hello JFall!"));
    }

    @Get("/{name}")
    public Single<Message> helloMessage(final String name) {
        return helloService.hello(name).map(greeting -> new Message(greeting));
    }

    @Get("/messages")
    public Publisher<Event<Message>> overflow() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                       .map(counter -> Event.of(new Message("Hello JFall and...")));
    }

}
