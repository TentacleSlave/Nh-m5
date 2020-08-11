package tdc.edu.vn.test.GiaoDien;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;

import tdc.edu.vn.test.R;

public class SettingActivity extends AppCompatActivity {

    Button btnVN, btnEN;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenNgonNgu("vn");

            }
        });
        btnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenNgonNgu("en");
            }
        });

    }

    public void chuyenNgonNgu(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent itent2 = new Intent(SettingActivity.this,SettingActivity.class);
        startActivity(itent2);
    }
    private void setControl() {

        btnEN = findViewById(R.id.btnEN);
        btnVN = findViewById(R.id.btnVN);


    }

    private void thoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
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


