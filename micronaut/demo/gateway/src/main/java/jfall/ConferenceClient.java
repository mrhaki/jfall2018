package jfall;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

@Retryable(attempts = "2", delay = "500ms")
@Client(id = "conference")
public interface ConferenceClient extends ConferenceOperations {
    
    @Get("/hello/reactive")
    Single<String> hello();
}
