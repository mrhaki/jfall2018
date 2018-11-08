package jfall;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/conferences")
public class ConferenceController {

    private final ConferenceOperations conferenceClient;

    public ConferenceController(final ConferenceOperations conferenceClient) {
        this.conferenceClient = conferenceClient;
    }

    @Get
    public Single<List<String>> names() {
        return conferenceClient.allConferences()
                               .map(this::convertConferences);
    }

    private List<String> convertConferences(List<Conference> conferences) {
        return conferences.stream()
                          .map(conf -> conf.getName().toUpperCase())
                          .collect(Collectors.toList());
    }
    
}
