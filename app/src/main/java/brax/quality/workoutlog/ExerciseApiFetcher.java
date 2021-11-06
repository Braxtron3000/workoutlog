package brax.quality.workoutlog;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ExerciseApiFetcher{



    @Headers({
            "x-rapidapi-host: exercisedb.p.rapidapi.com",
            "x-rapidapi-key: " +ApiHolder.apiKey
    })
    @GET
    Call<List<Exercise>> getExercises(@Url String url);

}