package brax.quality.workoutlog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Workout_list#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Workout_list extends Fragment {

    Workout powerWorkout = new Workout(getContext(), "dope power", "this is for dope power", "power");
    Workout sizeWorkout = new Workout(getContext(), "B.D.E", "use this workout for getting bigger arms", "size");
    Workout strengthWorkout = new Workout(getContext(), "iron man", "great leg exercises", "strength");


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Workout_list() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment workout_list.
     */
    // TODO: Rename and change types and number of parameters
    public static Workout_list newInstance(String param1, String param2) {
        Workout_list fragment = new Workout_list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_list, container, false);
    }

    ////add stuff here
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setRecyclerView();

        /*((Toolbar) getView().findViewById(R.id.topAppBar)).setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.actionItem_createWorkout) {
                    Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.action_workout_list_to_playlist);
                    Toolbar toolbar = getView().findViewById(R.id.topAppBar);

                    return true;
                } else {
                    Toast.makeText(getContext(), "there was an issue", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });*/

        ((Button)getView().findViewById(R.id.mtbttn_addExercise)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.action_workout_list_to_playlist);
            }
        });

    }




    public void setRecyclerView() {
        RecyclerView recyclerView = getView().findViewById(R.id.rcvw_workoutPlaylist);
        Workout[] allWorkouts = {powerWorkout, sizeWorkout, strengthWorkout};
        WorkoutAdapter customAdapter = new WorkoutAdapter(allWorkouts);
        recyclerView.setAdapter(customAdapter);
    }


}