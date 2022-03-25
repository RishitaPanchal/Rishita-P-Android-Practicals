package uiwidgetse.searchview.nestedscrollview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.databinding.ActivityWebviewBinding


class Webview : AppCompatActivity(), View.OnClickListener {

    /** Instance variable */
    private lateinit var binding: ActivityWebviewBinding

    @SuppressLint("SetJavaScriptEnabled")

    /** Instance method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.click = this
    }

    /** WebViewClient Class */
    inner class WebViewService : android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }
    }

    /** onCLick using Databinding */
    @SuppressLint("SetJavaScriptEnabled")
    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnHtml.id -> {
                Log.d("msg", "clickedd")
                binding.webview.loadUrl("file:///android_asset/htmlfiles/index.html")
            }
            binding.btnUrl.id -> {
                binding.webview.loadUrl("https://www.google.com/")
            }
            binding.btnLocalpdf.id -> {
                binding.webview.settings.setSupportZoom(true)
                binding.webview.settings.javaScriptEnabled = true
                binding.webview.webViewClient = WebViewService()
                binding.progressBar.visibility = View.VISIBLE
                val url = "http://www.africau.edu/images/default/sample.pdf"
                binding.webview.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
            }
        }
    }

}