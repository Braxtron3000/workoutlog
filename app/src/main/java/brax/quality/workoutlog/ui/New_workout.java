package brax.quality.workoutlog.ui;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import brax.quality.workoutlog.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New_workout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New_workout extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Playlist.
     */
    // TODO: Rename and change types and number of parameters
    public static New_workout newInstance(String param1, String param2) {
        New_workout fragment = new New_workout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public New_workout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        FragmentContainerView fragmentContainerView = getActivity().findViewById(R.id.fragmentContainerView);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_workout, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Toolbar toolbar = getView().findViewById(R.id.playlist_topActionBar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.save_icon) {
                    androidx.appcompat.app.AlertDialog builder = new MaterialAlertDialogBuilder(getContext(),
                            R.style.Theme_MaterialComponents_Light_Dialog_Alert)
                            .setTitle("Sure about saving?")
                            .setMessage("Are you sure you're finished?")
                            .setPositiveButton("Save", null)
                            .setNegativeButton("Cancel", null)
                            .show();

                    /*SaveWorkoutDialogFragment saveWorkoutDialogFragment = new SaveWorkoutDialogFragment();
                    saveWorkoutDialogFragment.show(getFragmentManager(), "SAve soMething");
                */
                }

                return true;
            }
        });

        ((Button) getView().findViewById(R.id.mtbttn_addExercise)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.exerciseFragment);
            }
        });

        /*toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.workout_list);
            }
        });*/
    }

    //created methods that go into the overrided methods.. mainly onViewCreated

    @Override
    public void onResume() {
        Log.d("onResume", "onResume");
        super.onResume();
    }

    public void addExercises() {
        Button button = (Button) getView().findViewById(R.id.mtbttn_addExercise);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "exercise created", Snackbar.LENGTH_SHORT).show();
                LinearLayout linearLayout = getView().findViewById(R.id.new_workout_ll_listOfExercises);
                View view1 = getLayoutInflater().inflate(R.layout.playlist_exercise_layout, linearLayout, false);

                //to create multiple sets, set onclick listener on the button within the exercise layout
                view1.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("SET BUTTON", "the button is clicked" + view1.findViewById(R.id.button).getParent().toString());
                        //linearLayout.addView(view1);
                    }
                });
                linearLayout.addView(view1);

            }
        });
    }

    public void save() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you're finished? \n you can always go back and edit later!")
                .setTitle("Sure about saving?")
                .setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //save the stuff
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .create();

        Navigation.findNavController(getActivity().findViewById(R.id.fragmentContainerView)).navigate(R.id.workout_list);
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_icon) {
            save();
            Log.d(TAG, "onOptionsItemSelected: true");
            return true;
        }
        else Log.d(TAG, "onOptionsItemSelected: false");

        return super.onOptionsItemSelected(item);
    }*/


}