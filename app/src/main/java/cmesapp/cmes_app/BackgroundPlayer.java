package cmesapp.cmes_app;

import android.media.MediaPlayer;

/**
 * Created by ASUS on 3/7/2018.
 */

public class BackgroundPlayer {

    //TODO Background Player

    public static MediaPlayer bgPlayer;

    public static void play() {
        bgPlayer.setLooping(true);
        bgPlayer.start();
    }

}
