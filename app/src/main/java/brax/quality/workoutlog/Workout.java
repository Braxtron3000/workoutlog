package brax.quality.workoutlog;

import android.content.Context;

public class Workout {
    private Context context;

    private String title;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    private String description;
    private String workoutType;

    public Workout(Context context, String title, String description, String workoutType){
        this.context = context;
        this.title = title;
        this.description = description;
        this.workoutType = workoutType;
    }


}
