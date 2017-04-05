package app.demo.parallax.viewanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewAnimator;

import app.demo.parallax.R;

public class MyViewAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewAnimator viewAnimator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_animator);

        viewAnimator = (ViewAnimator) findViewById(R.id.viewanimator);
        findViewById(R.id.button10).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        viewAnimator.showNext();
    }
}
