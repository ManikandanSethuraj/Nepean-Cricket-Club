package com.manikandansethuraj.nepeancricketclub;

/**
 * Created by ManikandanSethuraj on 2016-02-21.
 */
public class Application {
    private  String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    @Override
    public String toString() {
        return "" + getTitle() + "\n";
    }
}