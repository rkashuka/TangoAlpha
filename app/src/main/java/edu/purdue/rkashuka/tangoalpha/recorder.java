package edu.purdue.rkashuka.tangoalpha;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class recorder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button recordButton =
                (Button) findViewById(R.id.recordButton);
        Button cap =
                (Button) findViewById(R.id.btnCapture);
        Button nextButton = (Button) findViewById(R.id.btnSave);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), success.class);
                startActivity(i);
            }
        });
        if (!hasCamera()) {
            recordButton.setEnabled(false);
            cap.setEnabled(false);
        }
    }

    private boolean hasCamera() {
        if (getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY)){
            return true;
        } else {
            return false;
        }
    }

    private static final int VIDEO_CAPTURE = 101;
    private static final int IMAGE_CAPTURE = 102;
    private Uri fileUri1;
    private Uri fileUri2;
    private Uri fileUri3;

    public void startRecording(View view) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile1 = new
                File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myvideo_" + timeStamp + ".mp4");
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        fileUri1 = Uri.fromFile(mediaFile1);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri1);
        startActivityForResult(intent, VIDEO_CAPTURE);
    }

    public void clickImage(View view) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile = new
                File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/IMG_" + timeStamp + ".jpg");

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri2 = Uri.fromFile(mediaFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri2);
        startActivityForResult(intent, IMAGE_CAPTURE);
    }


    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Video has been saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
                capture c = new capture(data.getData().toString());
                c.convert();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Image has been saved ", Toast.LENGTH_LONG).show();
        }
    }
}