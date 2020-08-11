package tdc.edu.vn.test.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperSanPham extends SQLiteOpenHelper {


    public DBHelperSanPham(Context context) {
        super(context, "QLSanPham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table SanPham(masp txt,tensp text,loai text)" ;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
