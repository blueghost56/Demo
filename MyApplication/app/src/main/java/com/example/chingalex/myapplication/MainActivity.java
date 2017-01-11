package com.example.chingalex.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chingalex.myapplication.widgets.AdvancedWebView;


public class MainActivity extends AppCompatActivity implements AdvancedWebView.Listener{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private AdvancedWebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.loadUrl("http://m.wenhuapiaohao.com");

    }

    @Override
    protected void onResume(){
        super.onResume();
        mWebView.onResume();
    }
    @Override
    protected void onPause(){
        mWebView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        mWebView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed(){
        if(!mWebView.onBackPressed()){return;}
        super.onBackPressed();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }
}
