package app.demo.parallax.imageswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import app.demo.parallax.R;

public class MyImageSwitcher extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private int count = 1;
    private Animation out = null;
    private Animation in = null;
    private Animation fout = null;
    private Animation fin = null;
    private ImageSwitcher imageSwitcher = null;
    private int[] i = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.q,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_switcher);
        out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        fout = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        fin = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        imageSwitcher.setFactory(this);
        for (int x = 0; x < 26; x++) {
            imageSwitcher.setImageResource(i[x]);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {

            count++;
            imageSwitcher.setInAnimation(in);
            imageSwitcher.setOutAnimation(out);
            imageSwitcher.showNext();
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {

            count--;
            imageSwitcher.setInAnimation(fin);
            imageSwitcher.setOutAnimation(fout);
            imageSwitcher.showPrevious();

        }
        return true;
    }

    @Override
    public View makeView() {
        ImageView view = (ImageView) getLayoutInflater().inflate(R.layout.image_layout, null);
        view.setImageResource(i[count]);
        return view;
    }
}
