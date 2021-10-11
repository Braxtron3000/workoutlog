package brax.quality.workoutlog;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

import brax.quality.workoutlog.placeholder.PlaceholderContent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 */

// Todo: exerciseFragment needs MVVM
public class ExerciseFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private ExerciseApiFetcher jsonPlaceHolderAPI;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ExerciseFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ExerciseFragment newInstance(int columnCount) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    //create the views
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        //set the api fetch
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create an instance of the Interface using the base url of the Retrofit
        jsonPlaceHolderAPI = retrofit.create(ExerciseApiFetcher.class);

        //create a call from a list of comments from the Interface calling all the comments
        Call<List<Exercise>> call = jsonPlaceHolderAPI.getExercises("https://jsonplaceholder.typicode.com/posts/3/comments");

        //call the enqueue
        call.enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {
                if (!response.isSuccessful()) {
                    Log.d("BIG WRONG", response.message().toString());
                    return;
                }
                List<Exercise> exercises = response.body();

                if (view instanceof RecyclerView) {
                    Context context = view.getContext();
                    RecyclerView recyclerView = (RecyclerView) view;


                    /*if (mColumnCount <= 1) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    } else {
                        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                    }*/
                    recyclerView.setAdapter(new MyExerciseRecyclerViewAdapter(exercises));
                    int count = (new MyExerciseRecyclerViewAdapter(exercises)).getItemCount();
                    Log.d("RECYCLERVIEW LENGTH",count+"");
                }


            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                Log.d("api fetch failure","failure to call api");
            }
        });
        return view;
    }
}