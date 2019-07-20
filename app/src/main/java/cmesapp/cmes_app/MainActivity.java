package cmesapp.cmes_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SoundPlayer soundPlayer;

    MyAccount myAccount = new MyAccount();

    RelativeLayout btnContinue;
    TextView btnContinue_text, btnNewGame, vUser;

    Toast toast;


    SharedPreferences sharedPref;

    Animation uptodown, downtoup, bounce;

    String my_user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPlayer = new SoundPlayer(this);

        sharedPref = getSharedPreferences("CMES", Context.MODE_PRIVATE);

        btnContinue = (RelativeLayout) findViewById(R.id.id_btnContinue_main);
        btnContinue_text = (TextView) findViewById(R.id.id_btnContinue_text_main);
        btnNewGame = (TextView) findViewById(R.id.id_newgame_main);
        vUser = (TextView) findViewById(R.id.id_user_main);



        //TODO check user if null
        String user = sharedPref.getString("user","null");

        if (user.equals("null")) {

            vUser.setVisibility(View.GONE);
            btnContinue_text.setText("NEW USER");
            btnNewGame.setVisibility(View.GONE);

        } else {
            vUser.setVisibility(View.VISIBLE);
            vUser.setText(user);
            btnContinue_text.setText("CONTINUE");
            btnNewGame.setVisibility(View.VISIBLE);
        }




        btnContinue.setOnClickListener(this);
        btnContinue_text.setOnClickListener(this);
        btnNewGame.setOnClickListener(this);

    }

    public void show(String msg) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(MainActivity.this,msg ,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        if (view == btnContinue || view == btnContinue_text) {
            if (btnContinue_text.getText().toString().equals("CONTINUE")) {
                //TODO CONTINUE (OKAY)
                soundPlayer.playPopNext();

                String user = sharedPref.getString("user","null");




                //show( new Database_Helper(MainActivity.this).displayID(vUser.getText().toString()));


                if (!user.equals(vUser.getText().toString())) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("user", vUser.getText().toString());

                    editor.putString("english_last_result", "0");
                    editor.putString("filipino_last_result", "0");
                    editor.putString("science_last_result", "0");

                    editor.putString("english_best_result", "0");
                    editor.putString("filipino_best_result", "0");
                    editor.putString("science_best_result", "0");
                    editor.apply();
                }

                user = sharedPref.getString("user","null");

                MyAccount myAccount = new MyAccount();
                myAccount.setUser(user);



                Intent intent = new Intent(this,Category.class);
                startActivity(intent);



            } else {
                //TODO NEW GAME
                soundPlayer.playPopBack();

                AlertDialog.Builder dialog;
                dialog = new AlertDialog.Builder(this);
                dialog.setTitle("New Game");

                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setHint("Enter your name");
                input.setWidth(200);
                input.setHintTextColor(getResources().getColor(R.color.white1));
                input.setTextSize(20f);
                input.setPadding(10,5,10,5);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                dialog.setView(input)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                soundPlayer.playPopBack();
                                my_user = input.getText().toString();

                                //check user if already exists
//                                if (mDBHelper.saveUser(my_user)) {
//
//                                }
//
//                                mDBHelper.displayAccount(my_user);



                                if (!my_user.equals("")) {

                                    vUser.setVisibility(View.VISIBLE);
                                    vUser.setText(my_user.toUpperCase());
                                    btnContinue_text.setText("CONTINUE");
                                    btnNewGame.setVisibility(View.VISIBLE);

                                } else {
                                    show("User is required");
                                }
                            }
                        });
                dialog.show();



            }
        }







        if (view == btnNewGame) {
            soundPlayer.playPopBack();
            String user = sharedPref.getString("user","null");


            if ( (!user.equals("null")) || (!vUser.getText().toString().equals("")) ) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("New Game");
                    dialog.setMessage("Are you sure? The score will be reset.");
                dialog.setMessage("Are you sure?");
                dialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        soundPlayer.playPopBack();
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("user", "null");

                        editor.putString("english_last_result", "0");
                        editor.putString("filipino_last_result", "0");
                        editor.putString("science_last_result", "0");

                        editor.putString("english_best_result", "0");
                        editor.putString("filipino_best_result", "0");
                        editor.putString("science_best_result", "0");
                        editor.apply();


                        btnNewGame.setVisibility(View.GONE);
                        vUser.setVisibility(View.GONE);
                        btnContinue_text.setText("NEW USER");
//                        btnContinue.setBackgroundResource(R.drawable.oval);
//                        btnContinue_text.setTextColor(getResources().getColor(R.color.light));

                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        soundPlayer.playPopBack();
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        soundPlayer.playPopBack();
        super.onBackPressed();
    }
}
