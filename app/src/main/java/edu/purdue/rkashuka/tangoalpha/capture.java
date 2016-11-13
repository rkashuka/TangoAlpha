package edu.purdue.rkashuka.tangoalpha;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.media.AudioAttributes;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Rohan on 11/12/16.
 */
public class capture extends AppCompatActivity {
    String str;
    public capture(String s) {
        str = s;
    }
    public void convert() {
        File source = new File(str);
        File target = new File(str.substring(0,str.length() - 3) + "mp3");
        edu.purdue.rkashuka.tangoalpha.AudioAttributes  audioAttributes = new edu.purdue.rkashuka.tangoalpha.AudioAttributes();
        audioAttributes.setCodec("libmp3lame");

        audioAttributes.setBitRate(new Integer(128000));

        audioAttributes.setChannels(new Integer(2));
        audioAttributes.setSamplingRate(new Integer(44100));
        EncodingAttributes encodingAttributes = new EncodingAttributes();
        encodingAttributes.setFormat("mp3");

        encodingAttributes.setAudioAttributes(audioAttributes);
                //setAudioAttributes(audioAttributes);

        Encoder encoder = new Encoder();
        try {
            encoder.encode(source, target, encodingAttributes);
        }
        catch (Exception e) {

        }
    }
}