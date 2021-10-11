package brax.quality.workoutlog;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ExerciseApiFetcher {
    /*@GET("posts")
    Call<List<Exercise>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );
    @GET("posts")
    Call<List<Exercise>> getPosts(@QueryMap Map<String, String> parameters);
    @GET("posts/{id}/comments")
    Call<List<Exercise>> getExercises(@Path("id") int postId);*/
    @GET
    Call<List<Exercise>> getExercises(@Url String url);
}