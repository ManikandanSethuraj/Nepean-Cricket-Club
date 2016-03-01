package com.manikandansethuraj.nepeancricketclub;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.share.widget.LikeView;

public class HomePage extends AppCompatActivity {


    DataBasePlayers sqlDatabasePlayers;    // Defining Players DataBase for insertion purposes
    TextView groundDescription, clubDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        FacebookSdk.sdkInitialize(getApplicationContext());

        LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.STANDARD);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);
        likeView.setObjectIdAndType("https://www.facebook.com/Nepean-Cricket-Club-150173385134852/", LikeView.ObjectType.PAGE);

        sqlDatabasePlayers = new DataBasePlayers(this);// calling the Players databasePage
        DownloadData dw = new DownloadData();
        clubDescription = (TextView) findViewById(R.id.clubDescription);
        groundDescription = (TextView) findViewById(R.id.groundDescription);
        dw.execute();
        String groundDescrip = "5 Lynda Lane Park,"+"\n"+"Ottawa, Ontario,"+"\n"+"Canada."+"\n"+"K1H 5P3.";
        String clubDescrip = "Nepean Cricket Club alias NCC was founded in January 2008. " +
                "It was founded by a group of cricket enthusiasts to develop a sustainable and a successful" +
                " cricket community environment, which allows cricketers to develop and progress " +
                "to the highest level. Cricket is the most popular game among the commonwealth nations " +
                "and it has already shown a steady progress in Canada. " +
                "NCC is a full member of OVCC (Ottawa Valley Cricket Council) and has won the Citizen Division in 2013. "+
                "NCC has debuted more than 100 players in OVCC league and has almost 35 active players every year participating " +
                "in the Ottawa League.";
        groundDescription.setText(groundDescrip);
        clubDescription.setText(clubDescrip);


       // insertdata();   // insertion of players is done in this home page by calling insertdata
    }

    private class DownloadData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
           // Log.d("Async Task: ","Done1");
            String message = sqlDatabasePlayers.getAllData();
          //  Log.d("Async Task: ","Done2");// get all the data from Players Database
            int lengthofmessage = message.length(); // get the length of the message

            if (lengthofmessage == 0){    // check the size of the database, if filled with data don not rewrite in the players database
              //  Log.d("Async Task: ","Done3");

                sqlDatabasePlayers.insert("Roshan","Antonipillai","All-Rounder",59,50,282,42,15,14,411,11,18,7,21,3);
                sqlDatabasePlayers.insert("Suranjan","Arasaratnam","All-Rounder",70,64,725,53,34,32,510,28,70,64,793,53);
                sqlDatabasePlayers.insert("Jegan","Balachandran","All-Rounder",46,45,574,38,12,12,267,8,10,8,33,6);
                sqlDatabasePlayers.insert("Anand","Balaji","Fast-Bowler",4,2,3,3,14,6,9,15,4,2,0,0);
                sqlDatabasePlayers.insert("RajPratim","Bezbaruah","Spin-Bowler",5,4,21,4,18,14,43,21,11,7,3,6);
                sqlDatabasePlayers.insert("MohammadAli","Butt","All-Rounder",25,17,92,2,11,10,145,1,25,17,92,4);
                sqlDatabasePlayers.insert("JoseNirranjan","Jesudoss","WK",14,13,122,0,22,19,184,1,19,16,197,3);
                sqlDatabasePlayers.insert("Vimal","George","Batsman",6,4,43,0,10,7,80,0,8,4,42,0);
                sqlDatabasePlayers.insert("Balan","Jeya","All-Rounder",10,9,39,15,3,2,7,5,0,0,0,0);
                sqlDatabasePlayers.insert("Suthan","Kuhanesan","All-Rounder",82,77,1027,74,37,32,473,41,45,35,314,49);
                sqlDatabasePlayers.insert("Ashok","Kumar","All-Rounder",3,1,3,0,4,4,37,0,6,6,24,0);
                sqlDatabasePlayers.insert("Vignesh","Kuppuraj","All-Rounder",9,8,59,1,18,16,122,7,16,14,95,5);
                sqlDatabasePlayers.insert("Jenurius","Mark","Batsman",2,1,10,0,19,18,108,0,6,3,3,0);
                sqlDatabasePlayers.insert("Anwer","Omar","Bowler",23,18,9,31,7,7,17,12,2,2,0,0);
                sqlDatabasePlayers.insert("Sumeet","Patel","All-Rounder",18,16,146,21,28,23,210,42,19,11,61,29);
                sqlDatabasePlayers.insert("Vipin","Patre","All-Rounder",8,8,180,14,4,4,31,17,6,4,128,6);
                sqlDatabasePlayers.insert("Jithu","Paul","Batsman",10,9,122,1,13,12,195,5,11,11,129,4);
                sqlDatabasePlayers.insert("Aruna","Peiris","All-Rounder",13,10,99,11,6,6,80,11,10,10,246,11);
                sqlDatabasePlayers.insert("Anand","Raj","All-Rounder",2,2,5,0,7,3,29,1,6,5,35,3);
                sqlDatabasePlayers.insert("Pragash","Rajaswaran","Batsman",13,12,125,0,13,13,142,0,18,18,248,0);
                sqlDatabasePlayers.insert("Udhaykiran","Rangineni","Bowler",0,0,0,0,3,1,0,2,1,1,1,0);
                sqlDatabasePlayers.insert("Kogilan","Ravinthiran","All-Rounder",88,82,1051,115,36,33,679,52,64,56,928,64);
                sqlDatabasePlayers.insert("Rajeev","Sathirarasa","All-Rounder",2,2,7,0,5,5,34,3,0,0,0,0);
                sqlDatabasePlayers.insert("Jose","Sebastian","Batsman",0,0,0,0,5,4,19,0,0,0,0,0);
                sqlDatabasePlayers.insert("Sundar","Selvaraj","WK",16,15,249,1,22,20,285,0,19,19,277,0);
                sqlDatabasePlayers.insert("Manikandan","Sethuraj","All-Rounder",8,7,31,4,27,19,86,9,21,15,75,7);
                sqlDatabasePlayers.insert("Mayuran","Sivakumar","All-Rounder",28,25,114,20,13,11,103,6,23,13,66,13);
                sqlDatabasePlayers.insert("Sethan","Sundarsan","Batsman",58,56,697,5,21,21,290,2,34,28,461,8);
                sqlDatabasePlayers.insert("Suthershan","Sundralingam","Batsman",72,61,533,24,19,15,170,1,20,17,128,5);
                sqlDatabasePlayers.insert("Jamshed","Tareen","Bowler",9,6,51,9,5,3,8,8,8,3,3,9);
                sqlDatabasePlayers.insert("Dharmendra",	"Vilvarajah","Bowler",8,7,13,4,9,9,38,10,4,4,23,1);


            }

         //   Log.d("Async Task: ","Done");
            return null;
        }
    }



}
