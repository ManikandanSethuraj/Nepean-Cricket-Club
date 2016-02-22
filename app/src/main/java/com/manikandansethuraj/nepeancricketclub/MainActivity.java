package com.manikandansethuraj.nepeancricketclub;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    TabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tabhost = (TabHost) findViewById(android.R.id.tabhost);

        tabhost = getTabHost();

        TabHost.TabSpec tabHome = tabhost.newTabSpec("home");
        tabHome.setIndicator("Home", getResources().getDrawable(R.drawable.home));
        tabHome.setContent(new Intent(this, HomePage.class));
        tabhost.addTab(tabHome);


        TabHost.TabSpec tabLive = tabhost.newTabSpec("live");
        tabLive.setIndicator("Live");
        tabLive.setContent(new Intent(this, LivePage.class));
        tabhost.addTab(tabLive);

        TabHost.TabSpec tabOSCL = tabhost.newTabSpec("gallery");
        tabOSCL.setIndicator("OSCL");
        tabOSCL.setContent(new Intent(this, OsclPage.class));
        tabhost.addTab(tabOSCL);

        TabHost.TabSpec tabMore = tabhost.newTabSpec("more");
        tabMore.setIndicator("More..");
        tabMore.setContent(new Intent(this, MorePage.class));
        tabhost.addTab(tabMore);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
