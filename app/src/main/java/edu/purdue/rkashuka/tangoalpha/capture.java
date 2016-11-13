//package edu.purdue.rkashuka.tangoalpha;
//
//
//import android.content.Intent;
//
//import android.content.pm.ActivityInfo;
//import android.hardware.Camera;
//import android.media.CamcorderProfile;
//import android.media.MediaRecorder;
//import android.net.Uri;
//import android.os.Environment;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.SurfaceHolder;
//import android.widget.Button;
//import android.view.View;
//import android.content.Context;
//import android.widget.FrameLayout;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.Toast;
//
////import com.google.android.gms.appindexing.Action;
////import com.google.android.gms.appindexing.AppIndex;
////import com.google.android.gms.common.api.GoogleApiClient;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by Rohan on 11/12/16.
// */
//public class capture extends AppCompatActivity {
//    private Camera mCamera = null;
//    private recorder mCameraView = null;
//    private MediaRecorder reco = new MediaRecorder();
//    SurfaceHolder holder;
//    boolean recording = false;
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        //reco = new MediaRecorder();
//        setContentView(R.layout.activity_camera);
//
//        try {
//            mCamera = Camera.open();//you can use open(int) to use different cameras
//        } catch (Exception e) {
//            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
//        }
//
//        if (mCamera != null) {
//            mCameraView = new recorder(this, mCamera, reco);//create a SurfaceView to show camera data
//            FrameLayout camera_view = (FrameLayout) findViewById(R.id.camera_view);
//            camera_view.addView(mCameraView);//add the SurfaceView to the layout
//            holder = mCameraView.getHolder();
//        }
//
//        //btn to close the application
//        ImageButton imgClose = (ImageButton) findViewById(R.id.imgClose);
//        imgClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.exit(0);
//            }
//        });
//
//        Button cap = (Button) findViewById(R.id.cap);
//        cap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //mCamera.takePicture(null, null, mPicture);
//            }
//        });
//        //initRecorder();
//        final Button rec = (Button) findViewById(R.id.rec);
//        final ImageView i = (ImageView) findViewById(R.id.imageView);
//        rec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (reco == null) {
//                    reco = new MediaRecorder();
//                    reco.setAudioSource(MediaRecorder.AudioSource.MIC);
//                    reco.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//
//                    reco.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "myvideo.mp4");
//                    reco.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//                }//if
//
//                if (!recording)
//
//                {
//
//                  //  try {
//
//                        reco.start();
//                        rec.setText("Stop Recording");
//                        recording = true;
//                   // } catch (IOException e) {
//                    //    e.printStackTrace();
//                  //  }//catch
//                } else
//
//                {
//                    rec.setText("Start Recording");
//                    recording = false;
//                    reco.stop();
//                    reco.reset();
//                    reco.release();
//                    reco = null;
//                }//else
//            }
//        });
//    }
//
//            private void prepareRecorder() {
//                reco.setPreviewDisplay(holder.getSurface());
//
//                try {
//                    reco.prepare();
//                } catch (IllegalStateException e) {
//                    e.printStackTrace();
//                    finish();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    finish();
//                }
//            }
//
//            private void initRecorder() {
//
//
////        mCamera.unlock();
////        reco.setCamera(mCamera);
//                reco.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
//                reco.setVideoSource(MediaRecorder.VideoSource.CAMERA);
//                reco.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));
//
//                reco.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "myvideo.mp4");
//
//                reco.setMaxDuration(600000); //set maximum duration 60 sec.
//
//                reco.setMaxFileSize(50000000); //set maximum file size 50M
//
//
//                try {
//
//                    reco.prepare();
//
//                } catch (IllegalStateException e) {
//
//                    releaseMediaRecorder();
//
//
//                } catch (IOException e) {
//
//                    releaseMediaRecorder();
//
//
//                }
//
//            }
//
//
//            private void releaseMediaRecorder() {
//                if (reco != null) {
//                    reco.reset(); // clear recorder configuration
//                    reco.release(); // release the recorder object
//                    reco = null;
////            mCamera.lock(); // lock camera for later use
//                }
//            }
//
//
//            Camera.PictureCallback mPicture = new Camera.PictureCallback() {
//                @Override
//                public void onPictureTaken(byte[] data, Camera camera) {
//                    File pictureFile = getOutputMediaFile();
//                    if (pictureFile == null) {
//                        return;
//                    }
//                    try {
//                        FileOutputStream fos = new FileOutputStream(pictureFile);
//                        fos.write(data);
//                        fos.close();
//                    } catch (FileNotFoundException e) {
//
//                    } catch (IOException e) {
//                    }
//                }
//            };
//
//            private File getOutputMediaFile() {
//                File mediaStorageDir = new File(
//                        Environment
//                                .getExternalStoragePublicDirectory(Environment.getExternalStorageDirectory().getAbsolutePath()),
//                        "MyCameraApp");
//                if (!mediaStorageDir.exists()) {
//                    if (!mediaStorageDir.mkdirs()) {
//                        Log.d("MyCameraApp", "failed to create directory");
//                        return null;
//                    }
//                }
//                // Create a media file name
//                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//                        .format(new Date());
//                File mediaFile;
//                mediaFile = new File(mediaStorageDir.getPath() + File.separator
//                        + "IMG_" + timeStamp + ".jpg");
//
//                return mediaFile;
//            }
//
//            public void surfaceCreated(SurfaceHolder holder) {
//                prepareRecorder();
//            }
//
//            public void surfaceChanged(SurfaceHolder holder, int format, int width,
//                                       int height) {
//            }
//
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                if (recording) {
//                    reco.stop();
//                    recording = false;
//                }
//                reco.release();
//                finish();
//            }
//        }
//
////    @Override
////    public void onStart() {
////        super.onStart();
////
////        // ATTENTION: This was auto-generated to implement the App Indexing API.
////        // See https://g.co/AppIndexing/AndroidStudio for more information.
////        client.connect();
////        Action viewAction = Action.newAction(
////                Action.TYPE_VIEW, // TODO: choose an action type.
////                "capture Page", // TODO: Define a title for the content shown.
////                // TODO: If you have web page content that matches this app activity's content,
////                // make sure this auto-generated web page URL is correct.
////                // Otherwise, set the URL to null.
////                Uri.parse("http://host/path"),
////                // TODO: Make sure this auto-generated app deep link URI is correct.
////                Uri.parse("android-app://edu.purdue.rkashuka.tangoalpha/http/host/path")
////        );
////        AppIndex.AppIndexApi.start(client, viewAction);
////    }
////
////    @Override
////    public void onStop() {
////        super.onStop();
////
////        // ATTENTION: This was auto-generated to implement the App Indexing API.
////        // See https://g.co/AppIndexing/AndroidStudio for more information.
////        Action viewAction = Action.newAction(
////                Action.TYPE_VIEW, // TODO: choose an action type.
////                "capture Page", // TODO: Define a title for the content shown.
////                // TODO: If you have web page content that matches this app activity's content,
////                // make sure this auto-generated web page URL is correct.
////                // Otherwise, set the URL to null.
////                Uri.parse("http://host/path"),
////                // TODO: Make sure this auto-generated app deep link URI is correct.
////                Uri.parse("android-app://edu.purdue.rkashuka.tangoalpha/http/host/path")
////        );
////        AppIndex.AppIndexApi.end(client, viewAction);
////        client.disconnect();
////    }
