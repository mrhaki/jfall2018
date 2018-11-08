package jfall;

import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    Single<String> hello(String name) {
        return Single.just(String.format("Hello %s", name));
    }
    
}
