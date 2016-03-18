package com.cv.simons.simonborgstromcv;

/**
 * Created by Simons on 17/03/2016.
 */
public class Education {

    private String time;
    private String name;
    private String description;

    public Education(String time, String namn, String description) {
        this.time = time;
        this.name = namn;
        this.description = description;
    }

    public String getTime() {
        return time;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }


}
