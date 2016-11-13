package edu.purdue.rkashuka.tangoalpha;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;


import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    Objects obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_main);

        final EditText txtname = (EditText) findViewById(R.id.editName);
        final EditText txtbirth = (EditText) findViewById(R.id.editBirthday);
        final EditText txtdiag = (EditText) findViewById(R.id.editDiag);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                obj = new Objects(txtname.getText().toString(),txtbirth.getText().toString(),txtdiag.getText().toString());
                Intent i = new Intent(getApplicationContext(), recorder.class);
                startActivity(i);
            }
        });

        birthday bday = new birthday(this,R.id.editBirthday);
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        super.onCreate(savedInstanceState);
    }
//    public static void hideSoftKeyboard(Activity activity) {
//        InputMethodManager inputMethodManager =
//                (InputMethodManager) activity.getSystemService(
//                        Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(
//                activity.getCurrentFocus().getWindowToken(), 0);
//    }

}
