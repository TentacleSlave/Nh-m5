package tdc.edu.vn.test.GiaoDien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.res.Configuration;

import java.util.Locale;

import tdc.edu.vn.test.R;

public class HomeActivity extends AppCompatActivity implements SensorEventListener {
Button  btnSanPham, btnVN, btnEN;
    SensorManager sensorManager;
    long tgianTruoc;
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setControl();
        setEvent();
    }

    private void setEvent() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
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


        btnSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainSanPham.class);
                startActivity(intent);
            }
        });

    }
    public void chuyenNgonNgu(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent itent = new Intent(HomeActivity.this,HomeActivity.class);
        startActivity(itent);
    }
    private void setControl() {

        btnSanPham = findViewById(R.id.btnsanpham);

        btnEN = findViewById(R.id.btnEN);
        btnVN = findViewById(R.id.btnVN);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            // doi hinh
            layVecTorvathaydoitext(event);
        }
    }

    @Override
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
                    getWindow().getDecorView().setBackgroundColor(Color.rgb(0,255,0));
                }


            }

        }
    }
}
