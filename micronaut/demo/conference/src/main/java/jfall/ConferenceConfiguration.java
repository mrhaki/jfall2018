package jfall;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("conferences.mongo")
public class ConferenceConfiguration {
    
    private String collection;
    private String database;

    public String getCollection() {
        return collection;
    }

    public void setCollection(final String collection) {
        this.collection = collection;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(final String database) {
        this.database = database;
    }
}
