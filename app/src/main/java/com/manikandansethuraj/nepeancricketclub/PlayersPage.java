package com.manikandansethuraj.nepeancricketclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayersPage extends AppCompatActivity {

    DataBasePlayers sqlDatabasePlayers;

    private List<PlayerFrontPageClass> playerFrontPageClasses = new ArrayList<PlayerFrontPageClass>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_page);
        sqlDatabasePlayers = new DataBasePlayers(this);
        populatePlayersList();
        populatePlayersListView();
        registerCallBack();

    }

    private void populatePlayersList(){

         int count = sqlDatabasePlayers.getNumberofPlayers();
        Log.d("Players: ",String.valueOf(count));

        int countreader = 1;
       // String Player_Full_Details = null;
        String Player_NameFirst = null, Player_NameLast = null, Playe_Type = null;
        while (countreader <= count){
            //String players = sqlDatabasePlayers.getAllData();
          // Toast.makeText(this, "Player_Full :" + players, Toast.LENGTH_LONG).show();

        String players = sqlDatabasePlayers.getSinglePlayerDetail_Front(countreader);
        Player_NameFirst = players.substring(0, players.indexOf(" "));
        Player_NameLast = players.substring(players.indexOf(" ") + 1, players.indexOf("@"));
        Playe_Type = players.substring(players.indexOf("@")+1);


            switch (Player_NameLast){

                case "Antonipillai":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.roshan));
                    break;
                case  "Arasaratnam":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.sura));
                    break;
                case  "Butt":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.ali));
                    break;
                case "Balaji":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.anandb));
                    break;
                case "Raj":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.anandr));
                    break;
                case "Omar":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.anwer));
                    break;
                case "Kumar":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.ashok));
                    break;
                case "Jeya":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.balan));
                    break;
                case "Tareen":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.jammy));
                    break;
                case "Balachandran":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.jegan));
                    break;
                case "Mark":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.jenu));
                    break;
                case "Paul":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.jithu));
                    break;
                case "Jesudoss":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.josen));
                    break;
                case "Sebastian":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.joses));
                    break;
                case "Ravinthiran":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.kogi));
                    break;
                case "Bezbaruah":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.raj));
                    break;
                case "Patel":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.sumeet));
                    break;
                case "Kuhanesan":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.suthan));
                    break;
                case "Sundralingam":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.suthershan));
                    break;
                case "Rangineni":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.udhay));
                    break;
                case "Kuppuraj":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.vicky));
                    break;
                case "Patre":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.vipin));
                    break;
                case "Peiris":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.aruna));
                    break;
                case "Sathirarasa":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.rajeev));
                    break;
                case  "Selvaraj":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.sundar));
                    break;
                case "Sundarsan":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.senthan));
                    break;
                case "Vilvarajah":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.dharmi));
                    break;
                case "Sethuraj":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.mani));
                    break;
                case "Rajaswaran":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.prakash));
                    break;
                case "George":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.vimal));
                    break;
                case "Sivakumar":
                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.mayuran));
                    break;

                default:

                    playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.player_icon));
                    break;

            }



       // playerFrontPageClasses.add(new PlayerFrontPageClass(Player_NameFirst,Player_NameLast,Playe_Type,R.drawable.player_icon));
        countreader++;
        }

       // Toast.makeText(this,"Colume Count: "+count, Toast.LENGTH_LONG).show();

       // playerFrontPageClasses.add(new PlayerFrontPageClass("Dude","Dull","Dany",R.drawable.player_icon));

    }


    private void registerCallBack(){
        ListView list = (ListView) findViewById(R.id.playersslistView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                PlayerFrontPageClass clickedPlayer = playerFrontPageClasses.get(position);

                String clickedplayer_last_name = clickedPlayer.getPlayer_last_name();
                Intent intent = new Intent(PlayersPage.this,PlayerDetails.class);
                intent.putExtra("Last Name",clickedplayer_last_name);
                startActivity(intent);

            }
        });
    }

    private void populatePlayersListView(){
        ArrayAdapter<PlayerFrontPageClass> playersClassArrayAdapter = new MyPlayersArrayAdapter();
        ListView playersList = (ListView) findViewById(R.id.playersslistView);
        playersList.setAdapter(playersClassArrayAdapter);
    }

    private class MyPlayersArrayAdapter extends ArrayAdapter<PlayerFrontPageClass>{
        public MyPlayersArrayAdapter(){
            super(PlayersPage.this,R.layout.players_list_item, playerFrontPageClasses);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if (itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.players_list_item, parent, false);
            }

            PlayerFrontPageClass currentPlayer = playerFrontPageClasses.get(position);

            ImageView players_ImageView = (ImageView) itemView.findViewById(R.id.playersImageViewListitem);
            players_ImageView.setImageResource(currentPlayer.getPlayer_icon());


            TextView player_Name = (TextView)  itemView.findViewById(R.id.playersNametextView);
            String PlayerFirstName = currentPlayer.getPlayer_first_name().concat(" ").concat(currentPlayer.getPlayer_last_name());
            player_Name.setText(PlayerFirstName);

            TextView exec_Position = (TextView) itemView.findViewById(R.id.playerspositiontextView);
            exec_Position.setText(currentPlayer.getPlayer_Type());

            return itemView;
        }
    }










}
