package com.example.ucsm.studentrecordmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Naylay on 10/21/2016.
 */

public class WebsiteActivity extends AppCompatActivity {
        String[] url=new String[]{"http://www.ucsy.edu.mm","http://www.ucsm.edu.mm","http://cukly.moe-st.gov.mm","http://cupkku.moe-st.gov.mm"
        ,"http://cutgi.moe-st.gov.mm","http://cumyitkyina.moe-st.gov.mm","http://cubanmaw.moe-st.gov.mm","http://cumgy.moe-st.gov.mm","http://www.wikiwand.com","http://cumtla.moe-st.gov.mm"};

    private WebViewClient mClient = new WebViewClient();

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back1);

        actionBar.setTitle("Websites");
        actionBar.setElevation(6);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1aaeae")));
        Intent intent=getIntent();
     int position=intent.getIntExtra("position",1);

        WebView webview = new WebView(this);
        webview.setFitsSystemWindows(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(mClient);
        webview.loadUrl(url[position]);
        setContentView(webview);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
