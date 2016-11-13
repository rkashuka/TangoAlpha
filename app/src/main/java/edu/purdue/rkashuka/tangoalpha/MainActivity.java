package edu.purdue.rkashuka.tangoalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    String name = "";
    String birthday = "";
    String diagnosis = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = (Button) findViewById(R.id.btnStart);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), recorder.class);
//                startActivity(i);
//            }
//        });

        final EditText txtname = (EditText) findViewById(R.id.editName);
        final EditText txtbirth = (EditText) findViewById(R.id.editBirthday);
        final EditText txtdiag = (EditText) findViewById(R.id.editDiag);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                name = txtname.getText().toString();
                birthday = txtbirth.getText().toString();
                diagnosis = txtdiag.getText().toString();
                System.out.println("name="+name);
                System.out.println("birthday="+birthday);
                System.out.println("diagnosis="+diagnosis);
                Intent i = new Intent(getApplicationContext(), recorder.class);
                startActivity(i);
            }
        });
        birthday bday = new birthday(this,R.id.editBirthday);

    }

}
