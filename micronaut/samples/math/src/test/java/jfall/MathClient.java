package jfall;

import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface MathClient {

    @Named("math")
    Single<String> index();

}
