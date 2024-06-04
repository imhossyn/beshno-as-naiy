package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {

    private static String DATABASE_PATH = "";
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private Context mContext;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        DATABASE_PATH = context.getApplicationInfo().dataDir + "/databases/";
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null) mDataBase.close();
        super.close();
    }

    private boolean checkDataBase() {
        SQLiteDatabase tmpDB = null;
        try {
            String path = DATABASE_PATH + DATABASE_NAME;
            tmpDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception ex) {
        }

        if (tmpDB != null) tmpDB.close();
        return tmpDB != null;
    }

    public void copyDataBase() {
        try {
            InputStream inputStream = mContext.getAssets().open(DATABASE_NAME);
            String outputFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream outputStream = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read()) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openDataBase() {
        String path = DATABASE_PATH + DATABASE_NAME;
        mDataBase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDataBase() {
        boolean isDataBaseExist = checkDataBase();
        Log.d("database is exist", Boolean.toString(isDataBaseExist));
        if (!isDataBaseExist) {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (Exception ex) {
            }
        }
    }

    public List<PoemModel> getAllData() {
        List<PoemModel> listPoems = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Poems", null);
            if (c == null) return null;

            c.moveToFirst();
            int titleIndex = c.getColumnIndex("title");
            if (titleIndex == -1) {
                throw new IllegalArgumentException("Column 'title' does not exist in the database");
            }
            do {
                String title = c.getString(titleIndex);
                Log.d("title poem", title);
                PoemModel poem = new PoemModel(title);
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
