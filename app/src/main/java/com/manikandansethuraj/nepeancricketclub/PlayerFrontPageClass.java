package com.manikandansethuraj.nepeancricketclub;

/**
 * Created by ManikandanSethuraj on 2016-02-24.
 */
public class PlayerFrontPageClass {
    private String player_first_name;
    private String player_last_name;
    private String player_Type;
    private int player_icon;

    public PlayerFrontPageClass(String player_first_name, String player_last_name, String player_Type, int player_icon) {
        super();
        this.player_first_name = player_first_name;
        this.player_last_name = player_last_name;
        this.player_Type = player_Type;
        this.player_icon = player_icon;
    }

    public String getPlayer_first_name() {
        return player_first_name;
    }

    public String getPlayer_last_name() {
        return player_last_name;
    }

    public String getPlayer_Type() {
        return player_Type;
    }

    public int getPlayer_icon() {
        return player_icon;
    }
}
