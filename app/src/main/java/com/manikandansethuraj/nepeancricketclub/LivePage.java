package com.manikandansethuraj.nepeancricketclub;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LivePage extends AppCompatActivity {

    private ListView listApps;
    private String mFileContents;
    private SwipeRefreshLayout swipeRefreshView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        swipeRefreshView = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        listApps = (ListView) findViewById(R.id.xmlListView);
        // setSupportActionBar(toolbar);

        AlertDialog alertDialog = new AlertDialog.Builder(
                LivePage.this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Alert !!!");

        // Setting Dialog Message
        alertDialog.setMessage("Swipe to Load & Refresh Scores.");

        // Setting Icon to Dialog
       // alertDialog.setIcon(R.drawable.alert);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();




          if (isInternetAvailable()){
              swipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                  @Override
                  public void onRefresh() {

                      refreshcontent();

                  }

                  private void refreshcontent()
                  {
                      DownloadData downloadData = new DownloadData();
                      downloadData.execute("http://static.cricinfo.com/rss/livescores.xml");
                      ParseApplications parseApplications = new ParseApplications(mFileContents);
                      parseApplications.process();
                      ArrayAdapter<Application> arrayAdapter = new ArrayAdapter<Application>(
                              LivePage.this, R.layout.livepage_list_item, parseApplications.getApplications());
                      listApps.setAdapter(arrayAdapter);
                      swipeRefreshView.setRefreshing(false);
                  }

              });
          } else
          {
              AlertDialog alertConnection = new AlertDialog.Builder(
                      LivePage.this).create();

              // Setting Dialog Title
              alertConnection.setTitle("Check Connectivity !!");

              // Setting Dialog Message
              alertConnection.setMessage("No Internet, No Fun !!");

              // Setting Icon to Dialog
              // alertDialog.setIcon(R.drawable.alert);

              // Setting OK Button
              alertConnection.setButton("OK", new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int which) {

                  }
              });

              // Showing Alert Message
              alertConnection.show();
          }









    }

    public boolean isInternetAvailable() {
        ConnectivityManager conMgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        {
            NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

            if (netInfo == null)
            {

                return false;

            }
            else
            {
                return true;

            }

        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
        DownloadData downloadData = new DownloadData();
        downloadData.execute("http://static.cricinfo.com/rss/livescores.xml");



        ParseApplications parseApplications = new ParseApplications(mFileContents);
        parseApplications.process();
        ArrayAdapter<Application> arrayAdapter = new ArrayAdapter<Application>(
                LivePage.this, R.layout.livepage_list_item, parseApplications.getApplications());
        listApps.setAdapter(arrayAdapter);

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

    public void onResume(){
        super.onResume();
    }


    private class DownloadData extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            mFileContents = downloadXMLFile(params[0]);
            if (mFileContents == null){
              //  Log.d("DownloadData", "Error downloading");
            }
          //  Log.d("DownloadData", "The Values of mFiles: " + mFileContents);
            return mFileContents;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
          //  Log.d("DownloadData", "Result was : " + result);

        }

        private String downloadXMLFile(String urlPath){
            StringBuilder tempBuffer = new StringBuilder();
            try{
                URL url = new URL(urlPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
            //    Log.d("DownloadData", "The response code was" + response);
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int charRead;
                char[] inputBuffer = new char[500];
                while(true) {
                    charRead = isr.read(inputBuffer);
              //      Log.d("DownloadData", "The Char Read: " + charRead);
                    if (charRead <= 0)
                    {
                        break;
                    }
                    tempBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
                    //     Log.d("DownloadData","TempBuffer in Loop :" +tempBuffer.toString());
                }
                //  Log.d("DownloadData","Char Read Full : " + charRead);
                //  Log.d("DownloadData","TempBuffer" + tempBuffer.toString());
                return tempBuffer.toString();

            }catch (IOException e){
              //  Log.d("DownloadData","IO Exception reading data: " + e.getMessage());
                e.printStackTrace();
            }catch (SecurityException e){
              //  Log.d("DownloadData","Security Exception. Needs Permission? " + e.getMessage());
            }
            return null;
        }
    }
}
