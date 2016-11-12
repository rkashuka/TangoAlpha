package edu.purdue.rkashuka.tangoalpha;

import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * MotionTrackingRenderer renders graphic content. This includes the ground grid,
 * camera frustum, camera axis, and trajectory based on the Tango device's pose.
 */
public class MotionTrackingRenderer implements GLSurfaceView.Renderer {

    private final AssetManager mAssetManager;

    public MotionTrackingRenderer(AssetManager assetManager){
        mAssetManager = assetManager;
    }

    // Render loop of the Gl context.
    public void onDrawFrame(GL10 gl) {
        TangoJNINative.onGlSurfaceDrawFrame();
    }

    // Called when the surface size changes.
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        TangoJNINative.onGlSurfaceChanged(width, height);
    }

    // Called when the surface is created or recreated.
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        TangoJNINative.onGlSurfaceCreated(mAssetManager);
    }
}