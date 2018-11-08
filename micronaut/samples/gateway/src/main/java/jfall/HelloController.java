package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/hello")
public class HelloController {

    private final ConferenceOperations conferenceClient;

    public HelloController(final ConferenceOperations conferenceClient) {
        this.conferenceClient = conferenceClient;
    }

    @Get()
    public Single<String> helloJFall() {
        return conferenceClient.hello();
    }
}
