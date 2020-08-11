package tdc.edu.vn.test.GiaoDien;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.test.Adapter.CustomAdapterSanPham;
import tdc.edu.vn.test.Model.SanPham;
import tdc.edu.vn.test.DataBase.DBSanPham;
import tdc.edu.vn.test.R;

public class DanhSachSanPham extends AppCompatActivity implements SensorEventListener {
    ListView lvDanhSach;
    SensorManager sensorManager;
    long tgianTruoc;
    int i = 1;
    CustomAdapterSanPham adapter_CS;
    ArrayList<SanPham> data_CS = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }


    private void setEvent() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        DBSanPham dbCaSi = new DBSanPham(this);
        data_CS = dbCaSi.LayDL();

        adapter_CS = new CustomAdapterSanPham(this, R.layout.list_item, data_CS);
        lvDanhSach.setAdapter(adapter_CS);
    }



    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            // doi hinh
            layVecTorvathaydoitext(event);
        }
    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void layVecTorvathaydoitext(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float vector = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        if (vector >= 2) {
            long tgSau = event.timestamp;
            if ((tgSau - tgianTruoc) > 400) {
                i++;

                if (i == 3) {
                    Intent intent = new Intent(this, MainSanPham.class);
                    startActivity(intent);

                }


            }
            tgianTruoc = tgSau;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView search = (SearchView) menu.findItem(R.id.mnSearch).getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(DanhSachSanPham.this,query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("a", newText);
                return false;
            }
        });
        return  super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);


    }
}
