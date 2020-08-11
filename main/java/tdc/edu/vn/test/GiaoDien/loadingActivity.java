package tdc.edu.vn.test.GiaoDien;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import tdc.edu.vn.test.R;

public class loadingActivity extends AppCompatActivity {
    ImageView img ,imgduaxe ;
    Animation animation=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        setControll();
        setEvent();
        animation = AnimationUtils.loadAnimation(this, R.anim.loadingrotate);
        img.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(loadingActivity.this,DangNhap.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void setEvent() {
    }

    private void setControll() {
        img  = findViewById(R.id.imgloading);
    }
}
