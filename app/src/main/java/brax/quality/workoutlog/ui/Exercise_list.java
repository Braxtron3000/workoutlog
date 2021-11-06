package brax.quality.workoutlog.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.LinkedList;
import java.util.List;

import brax.quality.workoutlog.Exercise;
import brax.quality.workoutlog.ExerciseApiFetcher;
import brax.quality.workoutlog.MyExerciseRecyclerViewAdapter;
import brax.quality.workoutlog.R;
import brax.quality.workoutlog.RecyclerItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 */

// Todo: exerciseFragment needs MVVM
public class Exercise_list extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    LinkedList<Exercise> addedExercises;

    private ExerciseApiFetcher jsonPlaceHolderAPI;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Exercise_list() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static Exercise_list newInstance(int columnCount) {
        Exercise_list fragment = new Exercise_list();
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
                .baseUrl("https://exercisedb.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create an instance of the Interface using the base url of the Retrofit
        jsonPlaceHolderAPI = retrofit.create(ExerciseApiFetcher.class);

        //create a call from a list of comments from the Interface calling all the comments
        Call<List<Exercise>> call = jsonPlaceHolderAPI.getExercises("https://exercisedb.p.rapidapi.com/exercises");

        //call the enqueue
        call.enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {
                if (!response.isSuccessful()) {
                    Log.d("BIG WRONG", response.message().toString());
                    return;
                }
                List<Exercise> exercises = response.body();

                //if (view instanceof RecyclerView) {
                    Context context = view.getContext();
                    RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.list);//view;
                    Log.d("BEFORE SET","BEFORE SET");
                    recyclerView.setAdapter(new MyExerciseRecyclerViewAdapter(exercises));
                    Log.d("AFTER SET","AFTER SET");
                    //set the onclick listener for each item in the recycleview
                    recyclerView.addOnItemTouchListener(
                            new RecyclerItemClickListener(context, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Exercise theClickedExercise = new Exercise();
                                    theClickedExercise.setName(
                                            ((TextView) view.findViewById(R.id.exercise_name)).getText().toString()
                                    );
                                    theClickedExercise.setTarget(
                                            ((TextView) view.findViewById(R.id.exercise_type)).getText().toString()
                                    );
                                    exercises.add(theClickedExercise);
                                    Log.d("exercise name", "name: " + theClickedExercise.getName());
                                    Log.d("exercise target", "target: " + theClickedExercise.getTarget());
                                    try {
                                        Log.d("tutorial gif","url: "+theClickedExercise.getGifUrl());
                                    }catch (Exception e){
                                        Log.d("tutorial gif","url not gotten");
                                    }

                                    //Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.gifViewFragment);

                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    // do whatever
                                }

                            })
                    );
                //}


            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                Log.d("api fetch failure", "failure to call api");
            }
        });
        return view;
    }


}
