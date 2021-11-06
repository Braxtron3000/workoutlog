package brax.quality.workoutlog;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 * // list of exercises to choose from
 */
public class MyExerciseRecyclerViewAdapter extends RecyclerView.Adapter<MyExerciseRecyclerViewAdapter.ViewHolder> {

    private final List<Exercise> mValues;

    public MyExerciseRecyclerViewAdapter(List<Exercise> items) {
        mValues = items;
    }

    //when each viewholder is created inflate the fragment item layout
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    //onbind tells what to set the values of the viewholder to
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Exercise exercise = mValues.get(position);
        holder.setName(exercise.getName());
        holder.setDescription(exercise.getTarget());

        try {
            holder.setExerciseTutorial(exercise.getGifUrl());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("holder.setExerciseTutorial", "you have an issue in the exercise RecyclerView. look at line 45.");
        }


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    //a class which templates what the characteristics of each exercise item.
    public class ViewHolder extends RecyclerView.ViewHolder {


        public final TextView name;
        public final TextView description;
        public final ImageView exerciseTutorialBtn;
        public final Context context;

        public void setName(String name) {
            this.name.setText(name);
        }

        public String getName() {
            return name.getText().toString();
        }

        public void setDescription(String description) {
            this.description.setText(description);
        }

        public void setExerciseTutorial(String url) throws IOException {
            Glide.with(context).load(url).into(exerciseTutorialBtn);
        }


        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            name = (TextView) view.findViewById(R.id.exercise_name);
            description = (TextView) view.findViewById(R.id.exercise_type);
            exerciseTutorialBtn = (ImageView) view.findViewById(R.id.imageButton);
        }


    }


}

