package app.demo.parallax.adapterviewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import app.demo.parallax.R;

public class MyAdapterViewFlipper extends AppCompatActivity {

    private float initialX;
    private CustomAdapter adapter = null;
    private AdapterViewFlipper adapterViewFlipper = null;
    private Integer[] i = new Integer[]{
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
        setContentView(R.layout.activity_my_adapter_view_flipper);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterviewflipper);

        adapter = new CustomAdapter(this, R.layout.image_layout, i);
        adapterViewFlipper.setAdapter(adapter);

        //adapterViewFlipper.setFlipInterval(4000);
//        adapterViewFlipper.startFlipping();
        //      adapterViewFlipper.setAutoStart(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {

        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = touchevent.getX();
                Toast.makeText(this, "action down", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = touchevent.getX();
                if (initialX > finalX) {
                    if (adapterViewFlipper.getDisplayedChild() == 1)
                        break;

//                    adapterViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
//                    adapterViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));

                    adapterViewFlipper.showNext();
                } else {
                    if (adapterViewFlipper.getDisplayedChild() == 0)
                        break;

//                    adapterViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.in_from_right));
//                    adapterViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.out_from_right));

                    adapterViewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }
}
