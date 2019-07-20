package cmesapp.cmes_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity implements OnClickListener{

    private Database_Helper mDBHelper;
    private SQLiteDatabase mDb;


    private SoundPlayer soundPlayer;

    ImageView myImage, btnBack;
    TextView btn1, btn2, btn3, btn4, vNo, vPoints, vAdditionScore, vTitle, vLevel;
    RelativeLayout btn1_bottom, btn2_bottom, btn3_bottom, btn4_bottom
            ,btn1_top, btn2_top, btn3_top, btn4_top;

    int b1,b2,b3,b4;

    Toast toast;

    MyList myList;

    Random random = new Random();

    String source_no[] = null;
    static Integer source_question[];
    String source_choices[][] = null;

    String no[] = null;
    int question[] = null;
    String choices[] = new String[4];

    String currentQuestion [] = null;
    String currentChoices [] = new String[4];
    String currentChoices_text [] = new String[4];

    MyAccount myAccount = new MyAccount();

    int add_score = 1;
    int myNo = 1;
    int index = 0;
    int myScore = 0;
    int limit = 20;
    int streak = 0;

    String btn_selected = "";

    boolean b = false;

    String sub = "";


    List<Integer> ar_question = null;
    List<List<String>> ar_choices = null;

    int mistakes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        soundPlayer = new SoundPlayer(this);

        btn1_bottom = (RelativeLayout) findViewById(R.id.id_btn1_bottom_quiz);
        btn2_bottom = (RelativeLayout) findViewById(R.id.id_btn2_bottom_quiz);
        btn3_bottom = (RelativeLayout) findViewById(R.id.id_btn3_bottom_quiz);
        btn4_bottom = (RelativeLayout) findViewById(R.id.id_btn4_bottom_quiz);
        btn1_top = (RelativeLayout) findViewById(R.id.id_top_btn1_quiz);
        btn2_top = (RelativeLayout) findViewById(R.id.id_top_btn2_quiz);
        btn3_top = (RelativeLayout) findViewById(R.id.id_top_btn3_quiz);
        btn4_top = (RelativeLayout) findViewById(R.id.id_top_btn4_quiz);


        myImage = (ImageView) findViewById(R.id.id_image_quiz);
        btnBack = (ImageView) findViewById(R.id.id_back_quiz);
        btn1 = (TextView) findViewById(R.id.id_btn1_quiz);
        btn2 = (TextView) findViewById(R.id.id_btn2_quiz);
        btn3 = (TextView) findViewById(R.id.id_btn3_quiz);
        btn4 = (TextView) findViewById(R.id.id_btn4_quiz);

        vTitle = (TextView) findViewById(R.id.id_quiz);
        vNo = (TextView) findViewById(R.id.id_no_quiz);
        vPoints = (TextView) findViewById(R.id.id_points_quiz);
        vAdditionScore = (TextView) findViewById(R.id.id_additionScore_quiz);

        vLevel = (TextView) findViewById(R.id.id_level_quiz);

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




        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        //get Data
        myList = new MyList();
        sub = getIntent().getExtras().getString("quiz_subject");
        vTitle.setText(sub + " QUIZ");



        nextLevel();

    }









    public void nextLevel() {

        myLength = 0;



        currentQuestion = null;
        currentChoices = new String[4];
        currentChoices_text = new String[4];


        myNo = 1;
        index = 0;


        ar_question = new ArrayList<>();
        ar_choices = new ArrayList<List<String>>();

        if (getIntent().getExtras().getString("quiz_subject").equals("SCIENCE")) {

            new Database_Helper(Quiz.this).check_level(myAccount.getUser(),"SCIENCE");

            vLevel.setText("Level " + myAccount.getLevel());

            for (int i = 1; i <= Integer.parseInt(myAccount.getLevel()); i++) {

                if (i == 1) {
                    Collections.addAll(ar_question,myList.science_seasons_question);
                    merge2d(myList.science_seasons_choices);
                    limit = 4;
                }else
                if (i == 2) {
                    Collections.addAll(ar_question,myList.science_partsofaplant_question);
                    merge2d(myList.science_partsofaplant_choices);
                    limit = 10;
                }else
                if (i == 3) {
                    Collections.addAll(ar_question,myList.science_thesolarsystem_question);
                    merge2d(myList.science_thesolarsystem_choices);
                    limit = 15;
                }else{
                    Collections.addAll(ar_question,myList.science_typesofweather_question);
                    merge2d(myList.science_typesofweather_choices);
                    limit = 20;
                }

            }

            int _mySize = ar_question.size();
            source_question = ar_question.toArray(new Integer[_mySize]);
            source_choices = toArray(ar_choices);
            setCountQuestion(_mySize);
            currentQuestion = new String[_mySize];





//            source_no = myList.science_no;
//            source_question = myList.science_question;
//            source_choices = myList.science_choices;
//            currentQuestion = new String[myList.science_question.length];
        }

        if (getIntent().getExtras().getString("quiz_subject").equals("ENGLISH")) {

            new Database_Helper(Quiz.this).check_level(myAccount.getUser(),"ENGLISH");
            vLevel.setText("Level " + myAccount.getLevel());

            for (int i = 1; i <= Integer.parseInt(myAccount.getLevel()); i++) {


                if (i == 1) {
                    Collections.addAll(ar_question,myList.english_animalfarm_question);
                    merge2d(myList.english_animalfarm_choices);
                    limit = 5;
                }else

                if (i == 2) {
                    Collections.addAll(ar_question,myList.english_insects_question);
                    merge2d(myList.english_insects_choices);
                    limit = 10;
                }else

                if (i == 3) {
                    Collections.addAll(ar_question,myList.english_partsofthebody_question);
                    merge2d(myList.english_partsofthebody_choices);
                    limit = 15;
                }else

                if (i == 4) {
                    Collections.addAll(ar_question,myList.english_shape_question);
                    merge2d(myList.english_shape_choices);
                    limit = 20;
                }else

                if (i == 5) {
                    Collections.addAll(ar_question,myList.english_number_question);
                    merge2d(myList.english_number_choices);
                    limit = 20;
                }
                else {
                    Collections.addAll(ar_question,myList.english_alphabet_question);
                    merge2d(myList.english_alphabet_choices);
                    limit = 20;
                }

            }


            int _mySize = ar_question.size();
            source_question = ar_question.toArray(new Integer[_mySize]);
            source_choices = toArray(ar_choices);
            setCountQuestion(_mySize);
            currentQuestion = new String[_mySize];





//            source_no = myList.english_no;
//            source_question = myList.english_question;
//            source_choices = myList.english_choices;
//            currentQuestion = new String[myList.english_question.length];
        }

        if (getIntent().getExtras().getString("quiz_subject").equals("FILIPINO")) {

            new Database_Helper(Quiz.this).check_level(myAccount.getUser(),"FILIPINO");
            vLevel.setText("Level " + myAccount.getLevel());

            for (int i = 1; i <= Integer.parseInt(myAccount.getLevel()); i++) {


                if (i == 1) {
                    Collections.addAll(ar_question,myList.filipino_animalfarm_question);
                    merge2d(myList.filipino_animalfarm_choices);
                    limit = 5;
                }else

                if (i == 2) {
                    Collections.addAll(ar_question,myList.filipino_insects_question);
                    merge2d(myList.filipino_insects_choices);
                    limit = 10;
                }else

                if (i == 3) {
                    Collections.addAll(ar_question,myList.filipino_partsofthebody_question);
                    merge2d(myList.filipino_partsofthebody_choices);
                    limit = 15;
                }else

                if (i == 4) {
                    Collections.addAll(ar_question,myList.filipino_shape_question);
                    merge2d(myList.filipino_shape_choices);
                    limit = 20;
                }else

                if (i == 5) {
                    Collections.addAll(ar_question,myList.filipino_number_question);
                    merge2d(myList.filipino_number_choices);
                    limit = 20;
                }
                else {
                    Collections.addAll(ar_question,myList.filipino_alphabet_question);
                    merge2d(myList.filipino_alphabet_choices);
                    limit = 20;
                }

            }


            int _mySize = ar_question.size();
            source_question = ar_question.toArray(new Integer[_mySize]);
            source_choices = toArray(ar_choices);
            setCountQuestion(_mySize);
            currentQuestion = new String[_mySize];







//            source_no = myList.filipino_no;
//            source_question = myList.filipino_question;
//            source_choices = myList.filipino_choices;
//            currentQuestion = new String[myList.filipino_question.length];
        }

        //show(source_question.length + "");



        nextQuestion();
    }















    int myLength = 0;

    public void merge2d(String my_ar[][]){

        for (int x = 0; x < my_ar.length; x++) {
            ar_choices.add(new ArrayList<String>());
            ar_choices.get(myLength).add(my_ar[x][0]);
            ar_choices.get(myLength).add(my_ar[x][1]);
            ar_choices.get(myLength).add(my_ar[x][2]);
            ar_choices.get(myLength).add(my_ar[x][3]);
            myLength++;
        }
    }

    public void setCountQuestion(int size) {
        source_no = new String[size];
        for (int i = 0; i < size; i++) {
            source_no[i] = i + "";
        }
    }

    public String[][] toArray(List<List<String>> list) {
        String[][] r = new String[list.size()][];
        int i = 0;
        for (List<String> next : list) {
            r[i++] = next.toArray(new String[next.size()]);
        }
        return r;
    }


    @Override
    public void onClick(View view) {
        if (view == btn1) {

            if (btn_selected.equals("processing"))
                return;



            if (b1 == 1){
                soundPlayer.playCorrect();
                disabled();
                btn1_bottom.setBackgroundResource(R.drawable.background_bottom_correct);
                b = true;
                //displayScore();
            }
            else{
                soundPlayer.playWrong();
                streak = 0;
                //vAdditionScore.setText("+1");
                btn1_bottom.setBackgroundResource(R.drawable.background_bottom_wrong);
                disabled();
                b = false;
                mistakes = 1;
            }

            pleaseWait();


        }

        if (view == btn2) {
            if (btn_selected.equals("processing"))
                return;


            if (b2 == 1){
                soundPlayer.playCorrect();
                disabled();
                btn2_bottom.setBackgroundResource(R.drawable.background_bottom_correct);
                //updateScore();
                //displayScore();
                b = true;
            }
            else{
                soundPlayer.playWrong();
                streak = 0;
                //vAdditionScore.setText("+1");
                btn2_bottom.setBackgroundResource(R.drawable.background_bottom_wrong);
                disabled();
                b = false;
                mistakes = 1;
            }

            pleaseWait();

        }

        if (view == btn3) {
            if (btn_selected.equals("processing"))
                return;


            if (b3 == 1){
                soundPlayer.playCorrect();
                disabled();
                btn3_bottom.setBackgroundResource(R.drawable.background_bottom_correct);
                //updateScore();
                //displayScore();
                b = true;
            }
            else{
                soundPlayer.playWrong();
                streak = 0;
                //vAdditionScore.setText("+1");
                btn3_bottom.setBackgroundResource(R.drawable.background_bottom_wrong);
                disabled();
                b = false;
                mistakes = 1;
            }

            pleaseWait();
        }

        if (view == btn4) {
            if (btn_selected.equals("processing"))
                return;


            if (b4 == 1){
                soundPlayer.playCorrect();
                disabled();
                btn4_bottom.setBackgroundResource(R.drawable.background_bottom_correct);
                //updateScore();
                //displayScore();
                b = true;
            }
            else{
                soundPlayer.playWrong();
                streak = 0;
                //vAdditionScore.setText("+1");
                btn4_bottom.setBackgroundResource(R.drawable.background_bottom_wrong);
                disabled();
                b = false;
                mistakes = 1;
            }

            pleaseWait();
        }

        if (view == btnBack) {
            soundPlayer.playPopBack();
//            finish();


            AlertDialog.Builder dialog = new AlertDialog.Builder(Quiz.this)
                    .setTitle("Exit the Quiz?")
                    .setMessage("Are you sure to exit the game? The point's will not be recorded, even if you're finish the quiz.")
                    .setIcon(R.drawable.icon)
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //show_hide(View.VISIBLE);
                            //isLeaving = false;
                            soundPlayer.playPopBack();
                        }
                    })
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            soundPlayer.playPopBack();
                            //playBackground();
                            finish();
                        }
                    })
                    .setCancelable(false);
            dialog.show();



        }
    }

    public void show(String msg) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(Quiz.this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void displayScore() {
        if (myScore <= 1)
            vPoints.setText(myScore + " POINT");
        else
            vPoints.setText(myScore + " POINTS");

    }

    public void updateScore() {
        streak++;
        myScore += add_score;
        displayScore();
        if (streak>=4){
            add_score = 10;
            vAdditionScore.setText("+10");
        }else if (streak  > 1 && streak <=3 ){
            add_score =3;
            vAdditionScore.setText("+3");
        }else{
            add_score =1;
            vAdditionScore.setText("+1");
        }
    }

    public void nextQuestion() {
        updateQuestion();
        btn_normal();
    }

    public void updateQuestion(){

        int _index=0;

        //check if question is already exist
        while (index < source_question.length){

            _index = random.nextInt(source_question.length);
            String sQ = source_no[_index];

            if(!isDuplicate_question(sQ)) {

                currentQuestion[index] = sQ;
                break;
            }
        }
        _question(_index);

        //show( "Question no:  " + _index);

        vNo.setText(myNo + "/" + limit);
        myNo++;
        index++;
    }

    public void _question(int _index) {


        //myImage.setBackgroundResource(source_question[_index]);
        //show(_index + "");
        myImage.setImageResource(source_question[_index]);

        //set value choices
        choices[0] = source_choices[_index][0];
        choices[1] = source_choices[_index][1];
        choices[2] = source_choices[_index][2];
        choices[3] = source_choices[_index][3];



        int choices_set = 0;

        currentChoices = new String[4];
        currentChoices_text = new String[4];

        //random choices
        while (choices_set < choices.length){

            _index = random.nextInt(choices.length);
            String c_text = choices[_index];
            if (!isDuplicate_choices(_index + "")){

                if (choices_set == 0)
                    b1 = _index+1;
                else if (choices_set == 1)
                    b2 = _index+1;
                else if (choices_set == 2)
                    b3 = _index+1;
                else if (choices_set == 3)
                    b4 = _index+1;
                currentChoices[choices_set] = _index + "";
                currentChoices_text[choices_set] = c_text;
                choices_set++;
            }
        }


        //set value to buttons
        btn1.setText(currentChoices_text[0]);
        btn2.setText(currentChoices_text[1]);
        btn3.setText(currentChoices_text[2]);
        btn4.setText(currentChoices_text[3]);


        //show(currentChoices_text[0] + " | " + currentChoices_text[1] + " | " + currentChoices_text[2] + " | " + currentChoices_text[3]);
    }


    public boolean isDuplicate_question(String question){
        for (int i = 0; i < currentQuestion.length; i++){
            if (currentQuestion[i] != null){
                if(currentQuestion[i].equals(question)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isDuplicate_choices(String setOption){
        for (int i = 0; i < currentChoices.length; i++){
            if (currentChoices[i] != null){
                if(currentChoices[i].equals(setOption)){
                    return true;
                }
            }
        }
        return false;
    }

    public void pleaseWait()
    {
        btn_selected = "processing";

        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                if (b)
                {
                    updateScore();
                }
                else
                {
                    streak =0;
                    add_score = 1;
                    vAdditionScore.setText("+1");
                }

                if (myNo > limit)
                {

                    if (mistakes == 1)
                        GameOver();
                    else {



                        AlertDialog.Builder dialog = new AlertDialog.Builder(Quiz.this)
                                .setTitle("Level " +myAccount.getLevel()+ " complete")
                                .setMessage("Proceed to the next level.")
                                .setNegativeButton("exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        GameOver();
                                    }
                                })
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        soundPlayer.playPopBack();
                                        //playBackground();




                                        int myLevelNow = Integer.parseInt( myAccount.getLevel());


                                        if (sub.equals("SCIENCE")) {
                                            new Database_Helper(Quiz.this).updateTopic(myAccount.getUser(),sub,myList.science_topics[myLevelNow],"NO");
                                            new Database_Helper(Quiz.this).updateLevel(myAccount.getUser(),sub,(myLevelNow+1) + "");
                                        }
                                        if (sub.equals("ENGLISH")) {
                                            new Database_Helper(Quiz.this).updateTopic(myAccount.getUser(),sub,myList.english_topics[myLevelNow],"NO");
                                            new Database_Helper(Quiz.this).updateLevel(myAccount.getUser(),sub,(myLevelNow+1) + "");
                                        }
                                        if (sub.equals("FILIPINO")) {
                                            new Database_Helper(Quiz.this).updateTopic(myAccount.getUser(),sub,myList.filipino_topics[myLevelNow],"NO");
                                            new Database_Helper(Quiz.this).updateLevel(myAccount.getUser(),sub,(myLevelNow+1) + "");
                                        }




                                        nextLevel();



                                    }
                                })
                                .setCancelable(false);
                        dialog.show();

                    }
                }
                else{
                    nextQuestion();
                }
            }
        }.start();
    }



    public void disabled()
    {

        btn1_top.setBackgroundResource(R.drawable.background_top_hide);
        btn2_top.setBackgroundResource(R.drawable.background_top_hide);
        btn3_top.setBackgroundResource(R.drawable.background_top_hide);
        btn4_top.setBackgroundResource(R.drawable.background_top_hide);

    }



    public void btn_normal()
    {
        btn1_top.setBackgroundResource(R.drawable.background_top);
        btn2_top.setBackgroundResource(R.drawable.background_top);
        btn3_top.setBackgroundResource(R.drawable.background_top);
        btn4_top.setBackgroundResource(R.drawable.background_top);
        btn1_bottom.setBackgroundResource(R.drawable.background_bottom);
        btn2_bottom.setBackgroundResource(R.drawable.background_bottom);
        btn3_bottom.setBackgroundResource(R.drawable.background_bottom);
        btn4_bottom.setBackgroundResource(R.drawable.background_bottom);
        btn_selected = "";
        b = false;
    }

    public void GameOver() {
        finish();
        Intent intent = new Intent(Quiz.this,Result.class)
                .putExtra("SUBJECT",sub)
                .putExtra("SCORE",myScore + "");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Quiz.this)
                .setTitle("Exit the Quiz?")
                .setMessage("Are you sure to exit the game? The point's will not be recorded, even if you're finish the quiz.")
                .setIcon(R.drawable.icon)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //show_hide(View.VISIBLE);
                        //isLeaving = false;
                        soundPlayer.playPopBack();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        soundPlayer.playPopBack();
                        //playBackground();
                        finish();
                    }
                })
                .setCancelable(false);
        dialog.show();

    }
}
