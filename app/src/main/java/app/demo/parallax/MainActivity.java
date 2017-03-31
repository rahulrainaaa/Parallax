package app.demo.parallax;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.demo.parallax.adapterviewflipper.MyAdapterViewFlipper;
import app.demo.parallax.imageswitcher.MyImageSwitcher;
import app.demo.parallax.stackview.MyStackViewActivity;
import app.demo.parallax.textswitcher.MyTextSwitchwer;
import app.demo.parallax.textureview.MyTextureViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CAMERA},
                1);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                startActivity(new Intent(this, MyImageSwitcher.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, MyAdapterViewFlipper.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, MyStackViewActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, MyTextSwitchwer.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, MyTextureViewActivity .class));
                break;

        }
    }
}
