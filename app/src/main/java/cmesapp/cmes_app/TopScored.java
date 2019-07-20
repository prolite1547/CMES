package cmesapp.cmes_app;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopScored extends AppCompatActivity implements View.OnClickListener{

    private Database_Helper mDBHelper;
    private SQLiteDatabase mDb;


    SoundPlayer soundPlayer;

    ImageView btnBack;
    TextView btnScience, btnEnglish, btnFilipino;
    RelativeLayout science_btm, english_btm, filipino_btm;

    private RecyclerView recyclerView;
    private topscore_Adapter adapter;

    private List<String> list_no, list_user, list_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_scored);

        list_no = new ArrayList<>();
        list_user = new ArrayList<>();
        list_score = new ArrayList<>();


        mDBHelper = new Database_Helper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        soundPlayer = new SoundPlayer(this);

        btnBack = (ImageView) findViewById(R.id.id_back_topscore);
        btnScience = (TextView) findViewById(R.id.id_science_topscore);
        btnEnglish = (TextView) findViewById(R.id.id_english_topscore);
        btnFilipino = (TextView) findViewById(R.id.id_filipino_topscore);

        science_btm = (RelativeLayout) findViewById(R.id.id_science_bottom_topscore);
        english_btm = (RelativeLayout) findViewById(R.id.id_english_bottom_topscore);
        filipino_btm = (RelativeLayout) findViewById(R.id.id_filipino_bottom_topscore);

        science_btm.setOnClickListener(this);
        english_btm.setOnClickListener(this);
        filipino_btm.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_topscore);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        show("Science");

    }

    public void show(String cat) {
        list_no = mDBHelper.getRank(cat);
        list_user = mDBHelper.getUser(cat);
        list_score = mDBHelper.getScore(cat);

        adapter = new topscore_Adapter(this,list_no,list_user,list_score);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onClick(View view) {

        if (view == btnBack) {
            soundPlayer.playPopBack();
            finish();
        }

        if (view == science_btm) {
            soundPlayer.playPopBack();
            btn_normal();
            science_btm.setBackgroundResource(R.drawable.background_bottom_selected);
            show("Science");
        }

        if (view == english_btm) {
            soundPlayer.playPopBack();
            btn_normal();
            english_btm.setBackgroundResource(R.drawable.background_bottom_selected);
            show("English");
        }

        if (view == filipino_btm) {
            soundPlayer.playPopBack();
            btn_normal();
            filipino_btm.setBackgroundResource(R.drawable.background_bottom_selected);


            show("Filipino");


        }

    }

    public void btn_normal() {
        science_btm.setBackgroundResource(R.drawable.background_bottom);
        english_btm.setBackgroundResource(R.drawable.background_bottom);
        filipino_btm.setBackgroundResource(R.drawable.background_bottom);
    }
}
