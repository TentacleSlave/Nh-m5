package tdc.edu.vn.test.GiaoDien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tdc.edu.vn.test.R;

public class Home extends AppCompatActivity {
 private Button btnNhanVien,btnKho ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    btnNhanVien=findViewById(R.id.btnNhanVien);
    btnKho=findViewById(R.id.btnKho);
    btnNhanVien.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Home.this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
        }
    });
    btnKho.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Home.this,HomeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
        }
    });
    }
}