package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
public EditText loginname,password;
public int count=0;
public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
public void login(View view){
        loginname=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPersonName2);
        Bundle bundle=getIntent().getBundleExtra("data");
        String user=bundle.getString("user");
        String pwd=bundle.getString("pwd");
        String logusr=loginname.getText().toString();
        String logpwd=password.getText().toString();
        if (user.equals(logusr)&&pwd.equals(logpwd)){
            Toast.makeText(Login.this, "login successful", Toast.LENGTH_SHORT).show();
        }else{
            count++;
            if(count==3){
                btn=findViewById(R.id.button);
                btn.setEnabled(false);
                Toast.makeText(Login.this, " failed login attempts ", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(Login.this, "login failed", Toast.LENGTH_SHORT).show();
            }
        }


}
}