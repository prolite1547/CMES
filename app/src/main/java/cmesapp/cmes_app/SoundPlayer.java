package cmesapp.cmes_app;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;

/**
 * Created by ASUS on 3/7/2018.
 */

public class SoundPlayer {


    private int Sound_POOL_MAX = 2;
    private AudioAttributes audioAttributes;

    private static SoundPool soundPool;
    private static int pop_back;
    private static int pop_next;
    private static int scoreSound;

    private static int science;
    private static int english;
    private static int filipino;

    private static int correct;
    private static int wrong;


    private Context context;

    public SoundPlayer (Context context) {

        // SoundPool is deprecated in API level 21. (Lollipop)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(Sound_POOL_MAX)
                    .build();
        } else {
            //SoundPool (int maxStreams, int streamType, int srcQuality)
            soundPool = new SoundPool(Sound_POOL_MAX, AudioManager.STREAM_MUSIC, 0);
        }

        this.context = context;

        pop_back = soundPool.load(context, R.raw.pop_back,1);
        pop_next = soundPool.load(context, R.raw.pop_next,1);

        science = soundPool.load(context, R.raw.science,1);
        english = soundPool.load(context, R.raw.english,1);
        filipino = soundPool.load(context, R.raw.filipino,1);

        correct = soundPool.load(context, R.raw.correct,1);
        wrong = soundPool.load(context, R.raw.wrong,1);

        //scoreSound = soundPool.load(context, R.raw.score, 1);
    }


    public void playPopBack() {
        soundPool.play(pop_back,1.0f,1.0f,0,1,1.0f);
    }

    public void playPopNext() {
        soundPool.play(pop_next,1.0f,1.0f,0,1,1.0f);
    }

    public void playScoreSound() {
        soundPool.play(scoreSound, 1.0f,1.0f,0,1,1.0f);
    }


    public void playEnglish() {
        soundPool.play(english,1.0f,1.0f,0,1,1.0f);
    }
    public void playScience() {
        soundPool.play(science,1.0f,1.0f,0,1,1.0f);
    }
    public void playFilipino() {
        soundPool.play(filipino,1.0f,1.0f,0,1,1.0f);
    }

    public void playCorrect() {
        soundPool.play(correct,1.0f,1.0f,0,1,1.0f);
    }

    public void playWrong() {
        soundPool.play(wrong,1.0f,1.0f,0,1,1.0f);
    }
}
