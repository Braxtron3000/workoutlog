package brax.quality.workoutlog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {
    private Workout[] localDataSet;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.play_workout_template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkoutAdapter.ViewHolder holder, int position) {
        holder.getTitleTextView().setText(localDataSet[position].getTitle());
        holder.getTv_description().setText(localDataSet[position].getDescription());
        holder.getTv_type().setText(localDataSet[position].getWorkoutType());
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    /*reference to the type of views I'm using goes here*/

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_type;

        public ViewHolder(View view) {
            super(view);
            tv_title = (TextView)view.findViewById(R.id.tv_workoutTitle);
            tv_description = (TextView)view.findViewById(R.id.tv_workoutDescription);
            tv_type = (TextView)view.findViewById(R.id.tv_workoutType);

        }

        public TextView getTitleTextView(){
            return tv_title;
        }

        public TextView getTv_description(){
            return tv_title;
        }

        public TextView getTv_type(){
            return tv_title;
        }

    }

    public WorkoutAdapter(Workout[] dataSet) {
        localDataSet = dataSet;
    }
}
