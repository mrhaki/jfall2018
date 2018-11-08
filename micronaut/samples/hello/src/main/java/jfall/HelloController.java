package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/hello")
public class HelloController {

    @Get
    public Single<String> index() {
        return Single.just("GraalVM says 'Hello JFall 2018!'");
    }
}
