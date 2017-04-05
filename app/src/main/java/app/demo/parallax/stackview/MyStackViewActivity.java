package app.demo.parallax.stackview;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.StackView;

import app.demo.parallax.R;

public class MyStackViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CustomAdapter adapter = null;
    private StackView stackView = null;
    /*private Integer[] i = new Integer[]{
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
*/
    private Integer[] i = new Integer[]{
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa,
            R.drawable.aa
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stack_view);

        stackView = (StackView) findViewById(R.id.stackview);

        adapter = new CustomAdapter(this, R.layout.image_layout, i);
        stackView.setAdapter(adapter);

        stackView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Snackbar.make(view, "on item click: " + position, Snackbar.LENGTH_SHORT).show();
    }
}
