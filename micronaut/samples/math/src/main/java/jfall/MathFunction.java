package jfall;

import io.micronaut.function.FunctionBean;

import java.util.function.Function;

@FunctionBean("is-even")
public class MathFunction implements Function<Request, Response> {

    @Override
    public Response apply(final Request value) {
        return new Response(value.getValue() % 2 == 0);
    }

}
