package jfall;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

@Fallback
public class ConferenceFallback implements ConferenceOperations{


    @Override
    public Single<String> hello() {
        return Single.just("Gateways says no");
    }
}
