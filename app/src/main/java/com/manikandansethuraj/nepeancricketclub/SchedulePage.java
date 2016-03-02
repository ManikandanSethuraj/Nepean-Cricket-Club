package com.manikandansethuraj.nepeancricketclub;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SchedulePage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);
        loadData();


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
    public void loadData() {
        WebView mWebView = (WebView) findViewById(R.id.webView);
        // mWebView = new WebView(SchedulePage.this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        // mWebView.setWebViewClient(new WebViewClient());
        //  mWebView.loadUrl("https://drive.google.com/file/d/0B3lZe4RbpAwMTXdpVk9iNnN0RGM/view?usp=sharing");
        //  setContentView(mWebView);

        if (isInternetAvailable()) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();

            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(SchedulePage.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            mWebView.loadUrl("https://drive.google.com/file/d/0B3lZe4RbpAwMTXdpVk9iNnN0RGM/view?usp=sharing");
        }else {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    SchedulePage.this).create();

            // Setting Dialog Title
            alertDialog.setTitle(" No Internet !!!");

            // Setting Dialog Message
            alertDialog.setMessage("Check your Connectivity !!.");

            // Setting Icon to Dialog
            // alertDialog.setIcon(R.drawable.alert);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    //  Intent intent = new Intent(LikeUsPage.this, MorePage.class);
                    //  startActivity(intent);

                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

    }

    @Override
    protected void onResume(){
        super.onResume();


    }
}







