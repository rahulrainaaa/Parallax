package app.demo.parallax.textureview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MyTextureViewActivity extends FragmentActivity implements TextureView.SurfaceTextureListener {

    private TextureView textureView = null;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textureView = new TextureView(this);
        setContentView(textureView);
        textureView.setSurfaceTextureListener(this);
        textureView.setAlpha(1.0f);
        textureView.setRotation(90.0f);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        mCamera = Camera.open();
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
        textureView.setLayoutParams(new FrameLayout.LayoutParams(previewSize.width, previewSize.height, Gravity.CENTER));
        try {
            mCamera.setPreviewTexture(surface);
        } catch (IOException t) {
            t.printStackTrace();
        }
        mCamera.startPreview();
        textureView.setAlpha(1.0f);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            if (mCamera == null) {
                return true;
            }
            Camera.Parameters params = mCamera.getParameters();
            params.setPreviewSize(640, 480);
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            params.setPictureFormat(ImageFormat.JPEG);
            mCamera.setParameters(params);
            mCamera.startPreview();
            mCamera.takePicture(null, null, null, new Camera.PictureCallback() {
                @Override
                public void onPictureTaken(byte[] data, Camera camera) {
                    Log.v("cameraaaaaaaaaaaaaaa", "picture-taken");
                    Bitmap b = BitmapFactory.decodeByteArray(data, 0, data.length - 1);
                    ImageView i = new ImageView(MyTextureViewActivity.this);
                    i.setRotation(90.0f);
                    i.setImageBitmap(b);
                    Toast t = new Toast(MyTextureViewActivity.this);
                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(i);
                    t.show();
                    b = null;
                    System.gc();
                }
            });
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
