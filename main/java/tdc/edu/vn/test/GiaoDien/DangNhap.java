package tdc.edu.vn.test.GiaoDien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tdc.edu.vn.test.R;

public class DangNhap extends AppCompatActivity {

    EditText username, password ,dkuser, dkpasswork;
    Button Exit, login, registration, cancel, agree;
    String ten, mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        setControl();
        setEvent();
    }
    private void setEvent() {
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DangNhap.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("bạn có chắc muốn thoát khỏi App");
                builder.setMessage("hay chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });

                builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DangNhap.this);
                dialog.setTitle("hộp thoại sử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dangky);
                final EditText dkuser = dialog.findViewById(R.id.txtdkusername);
                final EditText dkpassword = dialog.findViewById(R.id.txtdkpasswork);
                cancel = dialog.findViewById(R.id.btncancel);
                agree = dialog.findViewById(R.id.btnagree);
                agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = dkuser.getText().toString().trim();
                        mk = dkpasswork.getText().toString().trim();


                        dkuser.setText(ten);
                        dkpassword.setText(mk);

                        dialog.cancel();;
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().length() !=0 && password.getText().length() !=0){
                    if(username.getText().toString().equals(ten) && password.getText().toString().equals(mk)){
                        Toast.makeText(DangNhap.this, "bạn đăng nhập thành công", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DangNhap.this, Home.class);
                        startActivity(intent);
                    }else if(username.getText().toString().equals("nguyendinhthi") && password.getText().toString().equals("123456")){
                        Toast.makeText(DangNhap.this, "bạn đăng nhập thành công", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DangNhap.this, Home.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("username",ten);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(DangNhap.this, "bạn đã đăng nhập thất bại", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(DangNhap.this, "mời bạn nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setControl() {
        username = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        Exit = findViewById(R.id.btnExit);
        login  = findViewById(R.id.btnlogin);
        registration  = findViewById(R.id.btnregistration);
    }
}