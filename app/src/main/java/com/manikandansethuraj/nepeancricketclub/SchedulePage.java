package com.manikandansethuraj.nepeancricketclub;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class SchedulePage extends AppCompatActivity {

    ImageView pdfImageView;
    private static int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

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
    }




}







