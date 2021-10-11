package brax.quality.workoutlog;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Comment;

import brax.quality.workoutlog.placeholder.PlaceholderContent.PlaceholderItem;
import brax.quality.workoutlog.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 * // list of exercises to choose from
 */
public class MyExerciseRecyclerViewAdapter extends RecyclerView.Adapter<MyExerciseRecyclerViewAdapter.ViewHolder> {

    private final List<Exercise> mValues;

    public MyExerciseRecyclerViewAdapter(List<Exercise> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Exercise exercise = mValues.get(position);
        holder.setName(exercise.getExerciseTitle());
        holder.setDescription(exercise.getName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView name;
        public final TextView description;

        public void setName(String name) {
            this.name.setText(name);
        }

        public void setDescription(String description) {
            this.description.setText(description);
        }

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.exercise_name);
            description = (TextView) view.findViewById(R.id.exercise_type);
        }



    }


}

