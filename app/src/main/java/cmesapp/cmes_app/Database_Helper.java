package cmesapp.cmes_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 3/10/2018.
 */

public class Database_Helper extends SQLiteOpenHelper {






    private MyAccount myAccount = new MyAccount();

    private static String DB_NAME = "cmesdatascores";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;




    public Database_Helper(Context context) {


        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }


    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();
            copyDataBase();
            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }



    public void insertTopic(String user,String subject, String topic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("uname", user);
        cv.put("subject", subject);
        cv.put("topic", topic);
        db.insert("tbltopic",null,cv);
    }

    public void updateTopic(String user,String subject, String topic, String required) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put("subject", subject);
//        cv.put("topic", topic);
        cv.put("required", required);
        long res = db.update("tbltopic",cv,"uname=? and subject=? and topic=?",new String[]{user,subject,topic});
        if (res == -1) {
            //Toast.makeText(mContext,"No rows affected",Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(mContext,"Updated",Toast.LENGTH_SHORT).show();
        }
    }


    public boolean saveLevel(String user, String subject, String level) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("uname",user);
        cv.put("subject",subject);
        cv.put("level",level);
        long res = db.insert("tbllevel",null,cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean check_level(String user, String subject) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select level from tbllevel where uname like '"+user+"' and subject like '"+ subject +"'";
        Cursor cursor = db.rawQuery(query,null);
        boolean x = true;
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            myAccount.setLevel(cursor.getString(0));
        }else {
            x = false;
        }
        cursor.close();
        return x;
    }

    public void updateLevel(String user,String subject,String level) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("level", level);
        long res = db.update("tbllevel",cv,"uname=? and subject=?",new String[]{user,subject});
        if (res == -1) {
//            Toast.makeText(mContext,"No rows affected",Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(mContext,"Updated",Toast.LENGTH_SHORT).show();
        }
    }



    public boolean saveUser(String user, String category, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("uname",user);
        cv.put("category", category);
        cv.put("score", score);
        long res = db.insert("tblsc",null,cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String displayID(String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(id), uname from tblsc where uname like '"+user+"'",null);
        cursor.moveToFirst();
        String u = "";
        while (!cursor.isAfterLast()) {
            myAccount.setID(cursor.getInt(0));
            u = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();
        return u;
    }

    public boolean check_account_score(String user, String category, String score) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select uname, category, score from tblsc where uname like '"+ user +"' and category like '"+ category +"' and score like '"+ score +"'";
        Cursor cursor = db.rawQuery(query,null);
        boolean x = true;
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
        }else {
            x = false;
        }

        cursor.close();
        return x;
    }

    public boolean check_topic(String user, String subject, String topic, String status) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select subject, topic from tbltopic where uname like '"+user+"' and subject like '"+ subject +"' and topic like '"+ topic + "' and required like '"+ status +"%'";
        Cursor cursor = db.rawQuery(query,null);
        boolean x = true;
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
        }else {
            x = false;
        }
        cursor.close();
        return x;
    }







    public List<String> getRank(String cat){
        SQLiteDatabase db = this.getWritableDatabase();
        List<String> list = new ArrayList<>();
        int rank = 1;
        Cursor cursor = db.rawQuery("SELECT * FROM tblsc where category like '"+cat+"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String r = "";
            r = r.valueOf(rank);
            list.add(r);
            rank++;
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getUser(String cat){
        SQLiteDatabase db = this.getWritableDatabase();
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT uname FROM tblsc where category like '"+cat+"' order by score DESC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }






    public List<String> getScore(String cat){
        SQLiteDatabase db = this.getWritableDatabase();
        List<String> list = new ArrayList<>();
        String wew = "";
        try {
            Cursor cursor = db.rawQuery("SELECT score FROM tblsc where category like '"+cat+"' order by score DESC", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0) + "");
                wew = cursor.getString(0) + "";
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(mContext, e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

        return list;
    }


























    public void displayAccount(String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT user, science_score, english_score, filipino_score, random_score FROM tblUsers where user like '"+user+"'",null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            myAccount.setUser(cursor.getString(0));
            myAccount.setScience_score(Integer.parseInt(cursor.getString(1)));
            myAccount.setEnglish_score(Integer.parseInt(cursor.getString(2)));
            myAccount.setFilipino_score(Integer.parseInt(cursor.getString(3)));
            myAccount.setRandom_score(Integer.parseInt(cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
    }



    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        //InputStream mInput = mContext.getAssets().open(DB_NAME);
        InputStream mInput = mContext.getResources().openRawResource(R.raw.cmesdatascores);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
}
