package com.example.myapplication.activities

import android.graphics.Bitmap
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.myapplication.ApiCall.webViewInterface
import com.example.myapplication.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var url = intent.extras.getString(resources.getString(R.string.websiteURL))
        var webview:WebView  = findViewById<WebView>(R.id.descriptionWebview)
        var progressBar = findViewById<ProgressBar>(R.id.news_prog_bar)

        webview.loadUrl(url)
        
        webview.webViewClient = object : WebViewClient() {
             override fun onPageFinished(view: WebView?, url: String?) {
                 super.onPageFinished(view, url)
                 progressBar.visibility = View.GONE
             }

             override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                 super.onPageStarted(view, url, favicon)
                 progressBar.visibility = View.VISIBLE
             }
         }





    }
}
