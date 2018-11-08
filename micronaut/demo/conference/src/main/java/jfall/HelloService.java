package jfall;

import javax.inject.Singleton;

@Singleton
public class HelloService {
    
    public String hello(String name) {
        return "Hello " + name; 
    }
}
