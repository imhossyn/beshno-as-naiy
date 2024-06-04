package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class MyDBHelper extends SQLiteOpenHelper {

    private static String DATABASE_PATH = "";
    private static final String DATABASE_NAME = "database.sqlite3";
    private static final int DATABASE_VERSION = 2;

    private SQLiteDatabase mDataBase;
    private final Context mContext;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        DATABASE_PATH = mContext.getApplicationInfo().dataDir + "/databases/";
        Log.d("DBHelper", "database helper initialized.");
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null) mDataBase.close();
        SQLiteDatabase.releaseMemory();
        super.close();
    }

    public boolean checkDataBase() {
        SQLiteDatabase tmpDB = null;
        String path = DATABASE_PATH + DATABASE_NAME;
        try {
            final File file = new File(path);
            if (file.exists()) {
                return true;
            } else return false;
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void copyDataBase() {
        try {
            InputStream inputStream = mContext.getAssets().open(DATABASE_NAME);
            String outputFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("DBHelper", "database copied.");
    }

    public void openDataBase() {
        String path = DATABASE_PATH + DATABASE_NAME;
        mDataBase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDataBase() throws IOException {
        boolean mDatabaseExist = checkDataBase();
        if (!mDatabaseExist) {
            this.getReadableDatabase();
            this.close();
            copyDataBase();
            this.close();
        }
    }

    public ArrayList<PoemModel> getAllData() {
        try {
            createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<PoemModel> listPoems = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Poems", null);
            if (c == null) return null;

            c.moveToFirst();
            int dbIdIndex = c.getColumnIndex("id");
            int titleIndex = c.getColumnIndex("title");
            int levelIndex = c.getColumnIndex("level");
            int voiceUrlIndex = c.getColumnIndex("voice_url");
            do {
                String db_id = c.getString(dbIdIndex);
                String title = c.getString(titleIndex);
                String level = c.getString(levelIndex);
                String voice_url = c.getString(voiceUrlIndex);
                Log.d("title poem", title);
                PoemModel poem = new PoemModel(Integer.parseInt(db_id), Integer.parseInt(level), title, voice_url, null);
                listPoems.add(poem);
            } while (c.moveToNext());
            c.close();
        } catch (Exception ex) {
            Log.e("error get all data", ex.toString());
        }
        db.close();
        return listPoems;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
