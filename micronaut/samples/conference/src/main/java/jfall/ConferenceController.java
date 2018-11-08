package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.List;

@Controller("/conferences")
public class ConferenceController {
    
    private final ConferenceRepository conferenceRepository;

    public ConferenceController(final ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }
    
    @Get()
    public Single<List<Conference>> index() {
        return Flowable.fromPublisher(conferenceRepository.findAll()).toList();
    }
    
}
