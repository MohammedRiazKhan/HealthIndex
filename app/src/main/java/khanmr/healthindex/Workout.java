package khanmr.healthindex;

public class Workout {

    private int imageId;
    private String name;
    private String desc;

    public Workout(int imageId, String name, String desc) {
        this.imageId = imageId;
        this.name = name;
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
