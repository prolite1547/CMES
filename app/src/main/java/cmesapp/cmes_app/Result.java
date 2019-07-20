package cmesapp.cmes_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Result extends AppCompatActivity implements View.OnClickListener{


    SoundPlayer soundPlayer;

    TextView vscore, vsubject, vTryagain, vBacktomenu, vdesc, btnTopScore;

    String sub = "";
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        soundPlayer = new SoundPlayer(this);

        vscore = (TextView) findViewById(R.id.id_score_result);
        vTryagain = (TextView) findViewById(R.id.id_tryagain_result);
        vBacktomenu = (TextView) findViewById(R.id.id_backtomenu_result);
        vdesc = (TextView) findViewById(R.id.id_desc_result);
        vsubject = (TextView) findViewById(R.id.id_subject_result);
        btnTopScore = (TextView) findViewById(R.id.id_topScore_result);



        vscore.setText(getIntent().getExtras().getString("SCORE"));

        sub = getIntent().getExtras().getString("SUBJECT");

        vsubject.setText("You got:");
        int score = Integer.parseInt(vscore.getText().toString());


        MyAccount myAccount = new MyAccount();


        //check account if the score is the same


        //Log.d("CHECK", myAccount.getUser() + "- " + sub + " -"+ score + "");
        if (! new Database_Helper(Result.this).check_account_score(myAccount.getUser(),sub,score + "") ) {
            new Database_Helper(Result.this).saveUser(myAccount.getUser(),sub,score);
        }




        vdesc.setText(display_desc(score));

        vTryagain.setOnClickListener(this);
        vBacktomenu.setOnClickListener(this);
        btnTopScore.setOnClickListener(this);
    }


    public String display_desc(int score) {
        String msg = "";
        if (score == 0) {
            msg = "Better Luck Next Time";
        }
        else{
            String ar_msg[] = {
                    "Nice",
                    "Very Nice",
                    "Good",
                    "Good Job",
                    "Your are Amazing",
                    "Great",
                    "Very Satisfied",
                    "Not Bad"
            };
            int index = random.nextInt(ar_msg.length);
            msg = ar_msg[index];
        }

        return msg;
    }


    @Override
    public void onClick(View view) {

        if (view == vTryagain) {
            soundPlayer.playPopNext();
            Intent intent = new Intent(Result.this, Quiz.class)
                .putExtra("quiz_subject",sub);
            finish();
            startActivity(intent);
        }

        if (view == vBacktomenu) {
            soundPlayer.playPopBack();
            finish();
        }

        if (view == btnTopScore) {
            soundPlayer.playPopNext();
            Intent intent = new Intent(Result.this,TopScored.class);
            startActivity(intent);

        }

    }
}
