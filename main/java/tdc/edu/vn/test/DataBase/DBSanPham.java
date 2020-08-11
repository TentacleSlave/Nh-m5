package tdc.edu.vn.test.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.test.Model.SanPham;

public class DBSanPham {
    DBHelperSanPham dbHelperSanPham;

    public DBSanPham(Context context) {
        dbHelperSanPham = new DBHelperSanPham(context);
    }

    public void Them(SanPham sanPham)
    {
        SQLiteDatabase db = dbHelperSanPham.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSP", sanPham.getMasp());
        values.put("TenSP", sanPham.getTensp());
        values.put("Loai", sanPham.getLoai());
        db.insert("SanPham",null,values);
    }

    public ArrayList<SanPham> LayDL()
    {
        ArrayList<SanPham> data = new ArrayList<>();
        String sql="select * from SanPham";
        SQLiteDatabase db= dbHelperSanPham.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            SanPham sanPham = new SanPham();
            sanPham.setTensp(cursor.getString(0));
            sanPham.setMasp(cursor.getString(1));
            sanPham.setLoai(cursor.getString(2));
            data.add(sanPham);
        }
        while (cursor.moveToNext());

        return  data;
    }



    public  void Sua(SanPham sanPham)
    {

        SQLiteDatabase db = dbHelperSanPham.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSP", sanPham.getMasp());
        values.put("TenSP", sanPham.getTensp());
        values.put("Loai", sanPham.getLoai());
        db.update("SanPham",values,"MaSP ='"+ sanPham.getMasp() +"'",null);
    }


    public  void Xoa(SanPham sanPham)
    {

        SQLiteDatabase db = dbHelperSanPham.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSP", sanPham.getMasp());
        values.put("TenSP", sanPham.getTensp());
        values.put("Loai", sanPham.getLoai());
        db.delete("SanPham","MaSP = '"+ sanPham.getMasp()+"'",null);

    }

}
