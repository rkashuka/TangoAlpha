package edu.purdue.rkashuka.tangoalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class success extends AppCompatActivity {
    Objects obj = new Objects();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_success);
        TextView txtName = (TextView) findViewById(R.id.Name);
        TextView txtBirth = (TextView) findViewById(R.id.Birthday);
        TextView txtDiag = (TextView) findViewById(R.id.Diag);
        txtName.setText(obj.getName());
        txtBirth.setText(obj.getBirthday());
        txtDiag.setText(obj.getDiagnosis());
        super.onCreate(savedInstanceState);
        Button fab = (Button) findViewById(R.id.Save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

}
