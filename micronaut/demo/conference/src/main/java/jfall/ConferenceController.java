package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.List;

@Controller("/conferences")
public class ConferenceController {
    
    private final ConferenceRepository repository;

    public ConferenceController(final ConferenceRepository repository) {
        this.repository = repository;
    }

    @Get("/")
    public Single<List<Conference>> showAll() {
        return Flowable.fromPublisher(repository.findAll()).toList();
    }
}
