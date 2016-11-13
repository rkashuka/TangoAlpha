package edu.purdue.rkashuka.tangoalpha;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.media.MediaRecorder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.pm.PackageManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

//public class recorder extends ActionBarActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera);
//
//        Button recordButton =
//                (Button) findViewById(R.id.recordButton);
//
//        if (!hasCamera())
//            recordButton.setEnabled(false);
//    }
//
//    private boolean hasCamera() {
//        if (getPackageManager().hasSystemFeature(
//                PackageManager.FEATURE_CAMERA_ANY)){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private static final int VIDEO_CAPTURE = 101;
//    private static final int IMAGE_CAPTURE = 101;
//    private Uri fileUri;
//    private Uri fileUri2;
//    public void startRecording(View view) {
//        File mediaFile = new
//                File(Environment.getExternalStorageDirectory().getAbsolutePath()
//                + "/myvideo.mp4");
//
//        Intent intent1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//        final Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        fileUri = Uri.fromFile(mediaFile);
//
//        intent1.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//        startActivityForResult(intent1, VIDEO_CAPTURE);
//
//
//
////        intent2.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
////        startActivityForResult(intent2,IMAGE_CAPTURE);
//
//    }
//
//    protected void onActivityResult(int requestCode,
//                                    int resultCode, Intent data) {
//
//        if (requestCode == VIDEO_CAPTURE) {
//            if (resultCode == RESULT_OK) {
//                Toast.makeText(this, "Video has been saved to:\n" +
//                        data.getData(), Toast.LENGTH_LONG).show();
//            } else if (resultCode == RESULT_CANCELED) {
//                Toast.makeText(this, "Video recording cancelled.",
//                        Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(this, "Failed to record video",
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//}

public class recorder extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder mHolder;
    private Camera mCamera;
    private  MediaRecorder reco;
    public recorder(Context context, Camera camera, MediaRecorder recod){
        super(context);

        mCamera = camera;
        reco = recod;
        //get the holder and set this class as the callback, so we can get camera data here
        mHolder = getHolder();
        mHolder.addCallback(this);
//        mHolder.setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try{
            //when the surface is created, we can set the camera to draw images in this surfaceholder
            mCamera.setPreviewDisplay(surfaceHolder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d("ERROR", "Camera error on surfaceCreated " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        //before changing the application orientation, you need to stop the preview, rotate and then start it again
        if(mHolder.getSurface() == null)//check if the surface is ready to receive camera data
            return;

        try{
            mCamera.stopPreview();
        } catch (Exception e){
            //this will happen when you are trying the camera if it's not running
        }

        //now, recreate the camera preview
        try{
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();
        } catch (IOException e) {
            Log.d("ERROR", "Camera error on surfaceChanged " + e.getMessage());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //our app has only one screen, so we'll destroy the camera in the surface
        //if you are unsing with more screens, please move this code your activity
        mCamera.stopPreview();
        mCamera.release();
    }
}