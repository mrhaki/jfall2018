package jfall;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

import java.util.List;

@Retryable(attempts = "2", delay = "200ms")
@Client(id = "conference")
public interface ConferenceClient extends ConferenceOperations {

    @Get("/hello/reactive")
    Single<String> hello();

    @Get("/conferences")
    Single<List<Conference>> allConferences();
}
