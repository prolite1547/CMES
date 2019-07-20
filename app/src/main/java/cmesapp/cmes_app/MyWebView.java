package cmesapp.cmes_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class MyWebView extends AppCompatActivity implements View.OnClickListener{

    private SoundPlayer soundPlayer;

    TextView vTopic;
    WebView webView;
    ImageView btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        soundPlayer = new SoundPlayer(this);

        btnBack = (ImageView) findViewById(R.id.id_back_web);
        vTopic = (TextView) findViewById(R.id.id_topics_web);
        webView = (WebView) findViewById(R.id.id_web);

        String _url = getIntent().getExtras().getString("url");
        String _title = getIntent().getExtras().getString("title");

        vTopic.setText(_title);

//        webView = null;
        webView.loadUrl(_url);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnBack) {
            soundPlayer.playPopBack();
            finish();
        }



    }

    @Override
    public void onBackPressed() {
        soundPlayer.playPopBack();
        super.onBackPressed();
    }
}
