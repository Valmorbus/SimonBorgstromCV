package com.cv.simons.simonborgstromcv;

/**
 * Created by Simons on 17/03/2016.
 */
public class Work {
    private String time;
    private String title;
    private String description;

        public Work( String title,String time, String description) {
        this.time = time;
        this.title = title;
        this.description = description;
    }

    public String getTime() {
        return time;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title;
    }


}
