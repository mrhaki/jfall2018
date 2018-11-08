package jfall;

import io.reactivex.Single;

import java.util.List;

public interface ConferenceOperations {

    Single<String> hello();

    Single<List<Conference>> allConferences();
}
