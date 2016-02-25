package com.manikandansethuraj.nepeancricketclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

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
        Toast.makeText(PlayerDetails.this,FullDetails, Toast.LENGTH_SHORT).show();

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
            default:
               image.setImageResource(R.drawable.player_icon);
                break;

        }

    }
}
