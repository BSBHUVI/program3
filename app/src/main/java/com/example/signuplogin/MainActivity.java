package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public EditText name,password;
  public String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void signup(View view){
        name=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPersonName2);

        String username=name.getText().toString();
        String userpassword=password.getText().toString();
        if(validatepassword(userpassword)) {
            Bundle bundle = new Bundle();
            bundle.putString("user", username);
            bundle.putString("pwd", userpassword);
            Intent it = new Intent(this, Login.class);
            it.putExtra("data", bundle);
            startActivity(it);
        }else{
            Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
        }
    }
    public Boolean validatepassword(String userpassword){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(userpassword);
        return matcher.matches();

    }
}