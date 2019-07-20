package cmesapp.cmes_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Topics extends AppCompatActivity implements View.OnClickListener{

    private SoundPlayer soundPlayer;

    ImageView btnBack;
    TextView topics;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private TopicsAdapter adapter;

    private List <String> list;
    private int topics_image[] = null;
    private String topics_desc[] = null;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        soundPlayer = new SoundPlayer(this);

        topics = (TextView) findViewById(R.id.id_topics);
        btnBack = (ImageView) findViewById(R.id.id_back_topics);
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_topics);

        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        String subject_selected = getIntent().getExtras().getString("SUBJECT_SELECTED");
        topics_desc = getIntent().getExtras().getStringArray("TOPICS_DESC");
        topics_image = getIntent().getExtras().getIntArray("TOPICS_IMAGE");

        topics.setText(subject_selected + " TOPICS");


        list = new ArrayList<>();

        MyAccount myAccount = new MyAccount();

        for (int x = 0; x < topics_desc.length; x++){
            list.add(topics_desc[x]);

            //check if topics is already inserted to database
            if (!new Database_Helper(this).check_topic(myAccount.getUser(), subject_selected,topics_desc[x],"")) {
                new Database_Helper(this).insertTopic(myAccount.getUser(), subject_selected,topics_desc[x]);
//                show("inserted");
            }

            //default


            new Database_Helper(this).updateTopic(myAccount.getUser(),subject_selected,topics_desc[0],"NO");
        }

        adapter = new TopicsAdapter(this,topics_image,list,subject_selected);
        recyclerView.setAdapter(adapter);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == btnBack) {
            soundPlayer.playPopBack();
            finish();
        }

    }

    public void show(String msg) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(Topics.this, msg , Toast.LENGTH_SHORT);
        toast.show();
    }
}
