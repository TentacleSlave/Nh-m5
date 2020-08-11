package tdc.edu.vn.test.GiaoDien;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.test.Adapter.CustomAdapterSanPham;
import tdc.edu.vn.test.Model.SanPham;
import tdc.edu.vn.test.DataBase.DBSanPham;
import tdc.edu.vn.test.R;

public class MainSanPham extends AppCompatActivity {
    EditText txtTenSP, txtMaSP, txtLoai;
    Button btnThem, btnXoa, btnSua, btnClear;
    ListView lvDanhSach;
    ArrayList<SanPham> data_CS = new ArrayList<>();
    CustomAdapterSanPham adapter_CS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham);

        setControl();
        setEvent();

    }

    private void setEvent() {

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSanPham dbSanPham = new DBSanPham(getApplicationContext());
                SanPham sanPham = new SanPham();
                sanPham.setMasp(txtMaSP.getText().toString());
                sanPham.setTensp(txtTenSP.getText().toString());
                sanPham.setLoai(txtLoai.getText().toString());

                dbSanPham.Them(sanPham);
                Show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSanPham dbSanPham = new DBSanPham(getApplicationContext());
                SanPham sanPham = new SanPham();
                sanPham.setMasp(txtMaSP.getText().toString());
                sanPham.setTensp(txtTenSP.getText().toString());
                sanPham.setLoai(txtLoai.getText().toString());
                dbSanPham.Xoa(sanPham);
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSanPham dbSanPham = new DBSanPham(getApplicationContext());
                SanPham sanPham = new SanPham();
                sanPham.setMasp(txtMaSP.getText().toString());
                sanPham.setTensp(txtTenSP.getText().toString());
                sanPham.setLoai(txtLoai.getText().toString());
                dbSanPham.Sua(sanPham);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTenSP.setText("");
                txtMaSP.setText("");
                txtLoai.setText("");
            }
        });

    }

    private SanPham getSanPham() {
        SanPham sanPham = new SanPham();
        sanPham.setMasp(txtMaSP.getText().toString());
        sanPham.setTensp(txtTenSP.getText().toString());
        sanPham.setLoai(txtLoai.getText().toString());
        return sanPham;

    }
    public void Show()
    {
        DBSanPham dbSanPham = new DBSanPham(this);
        data_CS = dbSanPham.LayDL();
        adapter_CS = new CustomAdapterSanPham(this, R.layout.list_item, data_CS);
        lvDanhSach.setAdapter(adapter_CS);
    }




    private void setControl() {

        txtTenSP = findViewById(R.id.txtTensanpham);
        txtMaSP = findViewById(R.id.txtsanpham);
        txtLoai = findViewById(R.id.loaisp);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnClear = findViewById(R.id.btnClear);
        lvDanhSach = findViewById(R.id.lvDanhSach);

    }
    private void thoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainSanPham.this);
        builder.setTitle("Thông Báo !!!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn Muốn Thoát ?");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.mnHome:
                Intent intent2 = new Intent(this, HomeActivity.class);
                startActivity(intent2);
            case R.id.mnLuu:
                Log.d("test", "Lưu");
                break;
            case R.id.mnOpen:
                Intent intent = new Intent(this, DanhSachSanPham.class);
                startActivity(intent);
                break;
            case R.id.mnSetting:
                Intent intent3 = new Intent(this,SettingActivity.class);
                startActivity(intent3);
                break;
            case R.id.mnThoat:
                thoat();
                break;
        }
        return true;
    }

}
