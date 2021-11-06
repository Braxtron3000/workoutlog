package brax.quality.workoutlog;

import com.google.gson.annotations.SerializedName;

public class Exercise {

    private String name;
    private String target;
    private String gifUrl;

    public String getGifUrl() { return gifUrl; }
    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) { this.target = target; }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}
