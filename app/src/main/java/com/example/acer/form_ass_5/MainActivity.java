package com.example.acer.form_ass_5;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher{
    EditText login,password;
    CheckBox checkBox;
    Button btn1,btn2;

    SharedPreferences handle;
    SharedPreferences.Editor editor;

    String s1="";
    String s2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        login.addTextChangedListener(this);

        handle=getSharedPreferences("setting", MODE_PRIVATE);
        editor=handle.edit();

        //login.setText(handle.getString("username", "pankaj"));
        //password.setText(handle.getString("Password","android"));


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            s1=login.getText().toString();
            s2=password.getText().toString();

            if((s1).equals(s2)&& checkBox.isChecked()){
                                        editor.putString("uername",s1);
                                      editor.putString(s1,s1);
                                      editor.putString(s1+"Password",s2);
                                        editor.commit();
                                        Toast.makeText(this,"values saved",Toast.LENGTH_LONG).show();
                              }
                                else if(s1.equals(s2)&& !checkBox.isChecked()){
                                       Toast.makeText(this, "login successfull", Toast.LENGTH_LONG).show();
                                     }
            else if (!s1.equals(s2) && checkBox.isChecked()){

                Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show();
            }
            else if (!s1.equals(s2) && !checkBox.isChecked()){

                Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show();
            }
    }
        else {
            login.setText("");
            password.setText("");
        }
}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

       //if (s1.equals(handle.getString("username",""))){
         //   password.setText(handle.getString("Password",""));
        //}
    }

    @Override
    public void afterTextChanged(Editable s) {
        String userName = s.toString();

        if (handle.contains(userName)){
            password.setText(handle.getString(s1+"Password",""));
        }
    }
}
