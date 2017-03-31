package app.demo.parallax.stackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.StackView;

import app.demo.parallax.R;

public class MyStackViewActivity extends AppCompatActivity {

    private CustomAdapter adapter = null;
    private StackView stackView = null;
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
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stack_view);

        stackView = (StackView) findViewById(R.id.stackview);

        adapter = new CustomAdapter(this, R.layout.image_layout, i);
        stackView.setAdapter(adapter);


    }
}
