package khanmr.healthindex;

public class Diet {

    private int imageId;
    private String name;
    private String desc;

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Diet(int imageId, String name, String desc) {


        this.imageId = imageId;
        this.name = name;
        this.desc = desc;
    }
}
