package brax.quality.workoutlog;

import com.google.gson.annotations.SerializedName;

public class Exercise {
    private int userId;
    private int id;
    @SerializedName("name")
    private String name;
    private String title;
    @SerializedName("body")
    private String text;
    @SerializedName("email")
    private String exerciseTitle;


    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }




    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    /*public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }*/


}
