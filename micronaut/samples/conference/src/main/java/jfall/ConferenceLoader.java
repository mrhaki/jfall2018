package jfall;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.reactivex.Flowable;

import javax.inject.Singleton;

//@Singleton
@Requires(notEnv = Environment.TEST)
public class ConferenceLoader /*implements ApplicationEventListener<ServiceStartedEvent> */{
    
    private final ConferenceRepository conferenceRepository;

    public ConferenceLoader(final ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

//    @Override
    public void onApplicationEvent(final ServiceStartedEvent serviceStartedEvent) {
        Flowable.just("JFall", "JavaLand", "JFokus", "OracleCodeOne")
                .map(name -> new Conference(name))
                .flatMapSingle(conferenceRepository::save)
                .subscribe(System.out::println);
    }
}
