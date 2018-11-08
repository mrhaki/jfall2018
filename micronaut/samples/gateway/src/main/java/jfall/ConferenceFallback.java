package jfall;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

@Fallback
public class ConferenceFallback implements ConferenceOperations {
    @Override
    public Single<String> hello() {
        return Single.just("Gateways says Hello JFall!");
    }

    @Override
    public Single<List<Conference>> allConferences() {
        return Single.just(new ArrayList<>());
    }
}
