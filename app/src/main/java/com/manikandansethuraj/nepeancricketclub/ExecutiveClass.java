package com.manikandansethuraj.nepeancricketclub;

/**
 * Created by ManikandanSethuraj on 2016-02-22.
 */
public class ExecutiveClass {

    private String executive_name;
    private String executive_Position;
    private int exective_IconID;

    public ExecutiveClass(String executive_name, String executive_Position, int exective_IconID) {
        super();
        this.executive_name = executive_name;
        this.executive_Position = executive_Position;
        this.exective_IconID = exective_IconID;
    }

    public String getExecutive_name() {
        return executive_name;
    }

    public String getExecutive_Position() {
        return executive_Position;
    }

    public int getExective_IconID() {
        return exective_IconID;
    }
}
