package com.manikandansethuraj.nepeancricketclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerDetails extends AppCompatActivity {

    DataBasePlayers sqlDatabasePlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        sqlDatabasePlayers = new DataBasePlayers(this);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("Last Name");
      //  TextView textView = (TextView) findViewById(R.id.textviewdetails);
       // textView.setText(name);
        getDetailsofPlayer(name);


    }


    public void getDetailsofPlayer(String Name){
        ImageView image = (ImageView) findViewById(R.id.singlePlayerIcon);
        String FullDetails = sqlDatabasePlayers.getSinglePlayerPageDetails(Name);
       // Toast.makeText(PlayerDetails.this,FullDetails, Toast.LENGTH_SHORT).show();

        switch (Name){

            case "Antonipillai":
                   image.setImageResource(R.drawable.roshan);
                break;
            case  "Arasaratnam":
                image.setImageResource(R.drawable.sura);
                break;
            case  "Butt":
                image.setImageResource(R.drawable.ali);
                break;
            case "Balaji":
                image.setImageResource(R.drawable.anandb);
                break;
            case "Raj":
                image.setImageResource(R.drawable.anandr);
               break;
            case "Omar":
                image.setImageResource(R.drawable.anwer);
                break;
            case "Kumar":
                image.setImageResource(R.drawable.ashok);
              break;
            case "Jeya":
                image.setImageResource(R.drawable.balan);
               break;
            case "Tareen":
                image.setImageResource(R.drawable.jammy);
                break;
            case "Balachandran":
                image.setImageResource(R.drawable.jegan);
               break;
            case "Mark":
                image.setImageResource(R.drawable.jenu);
                break;
            case "Paul":
               image.setImageResource(R.drawable.jithu);
                break;
            case "Jesudoss":
               image.setImageResource(R.drawable.josen);
                break;
            case "Sebastian":
               image.setImageResource(R.drawable.joses);
                break;
            case "Ravinthiran":
                image.setImageResource(R.drawable.kogi);
                break;
            case "Bezbaruah":
                image.setImageResource(R.drawable.raj);
                break;
            case "Patel":
               image.setImageResource(R.drawable.sumeet);
                break;
            case "Kuhanesan":
                image.setImageResource(R.drawable.suthan);
                break;
            case "Sundralingam":
                image.setImageResource(R.drawable.suthershan);
               break;
            case "Rangineni":
               image.setImageResource(R.drawable.udhay);
                break;
            case "Kuppuraj":
                image.setImageResource(R.drawable.vicky);
               break;
            case "Patre":
                image.setImageResource(R.drawable.vipin);
               break;
            case "Peiris":
                image.setImageResource(R.drawable.aruna);
                break;
            case "Sathirarasa":
                image.setImageResource(R.drawable.rajeev);
                break;
            case  "Selvaraj":
                image.setImageResource(R.drawable.sundar);
                break;
            case "Sundarsan":
                image.setImageResource(R.drawable.senthan);
                break;
            case "Vilvarajah":
                image.setImageResource(R.drawable.dharmi);
                break;
            case "Sethuraj":
                image.setImageResource(R.drawable.mani);
                break;
            case "Sivakumar":
                image.setImageResource(R.drawable.mayuran);
                break;
            case "George":
                image.setImageResource(R.drawable.vimal);
                break;
            case "Rajaswaran":
                image.setImageResource(R.drawable.prakash);
                break;
            default:
               image.setImageResource(R.drawable.player_icon);
                break;

        }

        String First_Name = FullDetails.substring(0,FullDetails.indexOf(" "));
        String PlayerType = FullDetails.substring(FullDetails.indexOf(" ")+1,FullDetails.indexOf("!"));
        String FiveMatches = FullDetails.substring(FullDetails.indexOf("!")+1,FullDetails.indexOf("@"));
        String FiveInns = FullDetails.substring(FullDetails.indexOf("@")+1,FullDetails.indexOf("#"));
        String FiveRuns = FullDetails.substring(FullDetails.indexOf("#")+1,FullDetails.indexOf("$"));
        String FiveWkts = FullDetails.substring(FullDetails.indexOf("$")+1,FullDetails.indexOf("%"));
        String FourMatches = FullDetails.substring(FullDetails.indexOf("%")+1,FullDetails.indexOf("^"));
        String FourInns = FullDetails.substring(FullDetails.indexOf("^")+1,FullDetails.indexOf("&"));
        String FourRuns = FullDetails.substring(FullDetails.indexOf("&")+1,FullDetails.indexOf("*"));
        String FourWkts = FullDetails.substring(FullDetails.indexOf("*")+1,FullDetails.indexOf("<"));
        String TwoMatches = FullDetails.substring(FullDetails.indexOf("<")+1,FullDetails.indexOf(">"));
        String TwoInns = FullDetails.substring(FullDetails.indexOf(">")+1,FullDetails.indexOf("?"));
        String TwoRuns = FullDetails.substring(FullDetails.indexOf("?")+1,FullDetails.indexOf("+"));
        String TwoWkts = FullDetails.substring(FullDetails.indexOf("+")+1);

        String FullName = First_Name+" "+Name;
        TextView textName = (TextView) findViewById(R.id.PlayerName);
        TextView textType = (TextView) findViewById(R.id.PlayerType);
        TextView textmat50 = (TextView) findViewById(R.id.matches50);
        TextView textmat40 = (TextView) findViewById(R.id.matches40);
        TextView textmat20 = (TextView) findViewById(R.id.matches20);
        TextView textinn50 = (TextView) findViewById(R.id.inn50);
        TextView textinn40 = (TextView) findViewById(R.id.inn40);
        TextView textinn20 = (TextView) findViewById(R.id.inn20);
        TextView textruns50 = (TextView) findViewById(R.id.runs50);
        TextView textruns40 = (TextView) findViewById(R.id.runs40);
        TextView textruns20 = (TextView) findViewById(R.id.runs20);
        TextView textwkts50 = (TextView) findViewById(R.id.wkts50);
        TextView textwkts40 = (TextView) findViewById(R.id.wkts40);
        TextView textwkts20 = (TextView) findViewById(R.id.wkts20);

        textName.setText(FullName);
        textType.setText(PlayerType);
        textmat50.setText(FiveMatches);
        textmat40.setText(FourMatches);
        textmat20.setText(TwoMatches);
        textinn50.setText(FiveInns);
        textinn40.setText(FourInns);
        textinn20.setText(TwoInns);
        textruns50.setText(FiveRuns);
        textruns40.setText(FourRuns);
        textruns20.setText(TwoRuns);
        textwkts50.setText(FiveWkts);
        textwkts40.setText(FourWkts);
        textwkts20.setText(TwoWkts);



    }
}
