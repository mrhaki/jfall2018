package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/hello")
public class HelloController {

    @Get("/")
    public Single<String> hello() {
        return Single.just("Hello from GraalVM");
    }
}
