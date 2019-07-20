package cmesapp.cmes_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Category extends AppCompatActivity implements View.OnClickListener{
    private MyAccount myAccount;
    private MyList myList;

    private SoundPlayer soundPlayer;

    TextView btnTopScore;

    ImageView btnBack;
    RelativeLayout btnScience, btnEnglish, btnFilipino,
                    btnScience_learn, btnScience_quiz,
                    btnEnglish_learn, btnEnglish_quiz,
                    btnFilipino_learn, btnFilipino_quiz;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        myAccount = new MyAccount();

        soundPlayer = new SoundPlayer(this);

        myList = new MyList();

        btnTopScore = (TextView) findViewById(R.id.id_topScore_category);

        btnBack = (ImageView) findViewById(R.id.id_back_category);
        btnScience = (RelativeLayout) findViewById(R.id.id_science_category);
        btnEnglish = (RelativeLayout) findViewById(R.id.id_english_category);
        btnFilipino = (RelativeLayout) findViewById(R.id.id_filipino_category);

        btnScience_learn = (RelativeLayout) findViewById(R.id.id_science_learn_category);
        btnEnglish_learn = (RelativeLayout) findViewById(R.id.id_english_learn_category);
        btnFilipino_learn = (RelativeLayout) findViewById(R.id.id_filipino_learn_category);
        btnScience_quiz = (RelativeLayout) findViewById(R.id.id_science_quiz_category);
        btnEnglish_quiz = (RelativeLayout) findViewById(R.id.id_english_quiz_category);
        btnFilipino_quiz = (RelativeLayout) findViewById(R.id.id_filipino_quiz_category);


        btnBack.setOnClickListener(this);
        btnScience.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
        btnFilipino.setOnClickListener(this);

        btnScience_learn.setOnClickListener(this);
        btnEnglish_learn.setOnClickListener(this);
        btnFilipino_learn.setOnClickListener(this);
        btnScience_quiz.setOnClickListener(this);
        btnEnglish_quiz.setOnClickListener(this);
        btnFilipino_quiz.setOnClickListener(this);
        btnTopScore.setOnClickListener(this);





        MyAccount myAccount = new MyAccount();


        if (! new Database_Helper(Category.this).check_level(myAccount.getUser(),"SCIENCE")) {
            new Database_Helper(Category.this).saveLevel(myAccount.getUser(),"SCIENCE","1");
        }

        if (! new Database_Helper(Category.this).check_level(myAccount.getUser(),"ENGLISH")) {
            new Database_Helper(Category.this).saveLevel(myAccount.getUser(),"ENGLISH","1");
        }

        if (! new Database_Helper(Category.this).check_level(myAccount.getUser(),"FILIPINO")) {
            new Database_Helper(Category.this).saveLevel(myAccount.getUser(),"FILIPINO","1");
        }






//        show(myAccount.getID() + "");
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        if (view == btnTopScore) {
            soundPlayer.playPopBack();
            intent = new Intent(Category.this,TopScored.class);
            startActivity(intent);
        }

        if (view == btnBack) {
            soundPlayer.playPopBack();
            finish();
        }

        if (view == btnScience) {
            soundPlayer.playScience();

        }

        if (view == btnEnglish) {
            soundPlayer.playEnglish();
//            show("ENGLISH");
        }

        if (view == btnFilipino) {
            soundPlayer.playFilipino();
//            show("FILIPINO");
        }



        if (view == btnScience_learn) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this,Topics.class);
            intent.putExtra("MAIN_COLOR",R.color.blue);
            intent.putExtra("SUBJECT_SELECTED","SCIENCE");
            intent.putExtra("TOPICS_IMAGE",myList.science_image);
            intent.putExtra("TOPICS_DESC",myList.science_topics);
            startActivity(intent);
        }

        if (view == btnEnglish_learn) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this,Topics.class);
            intent.putExtra("MAIN_COLOR",R.color.blue);
            intent.putExtra("SUBJECT_SELECTED","ENGLISH");
            intent.putExtra("TOPICS_IMAGE",myList.english_image);
            intent.putExtra("TOPICS_DESC",myList.english_topics);
            startActivity(intent);
        }

        if (view == btnFilipino_learn) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this,Topics.class);
            intent.putExtra("MAIN_COLOR",R.color.blue);
            intent.putExtra("SUBJECT_SELECTED","FILIPINO");
            intent.putExtra("TOPICS_IMAGE",myList.filipino_image);
            intent.putExtra("TOPICS_DESC",myList.filipino_topics);
            startActivity(intent);
        }

        if (view == btnScience_quiz) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this, Quiz.class);
            intent.putExtra("quiz_subject","SCIENCE");
            startActivity(intent);

        }

        if (view == btnEnglish_quiz) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this, Quiz.class);
            intent.putExtra("quiz_subject","ENGLISH");
            startActivity(intent);
        }

        if (view == btnFilipino_quiz) {
            soundPlayer.playPopNext();
            intent = new Intent(Category.this, Quiz.class);
            intent.putExtra("quiz_subject","FILIPINO");
            startActivity(intent);
        }

    }

    public void show(String msg) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(Category.this,msg ,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        soundPlayer.playPopBack();
        super.onBackPressed();
    }
}
