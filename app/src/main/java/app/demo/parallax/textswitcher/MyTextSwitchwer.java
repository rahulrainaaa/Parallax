package app.demo.parallax.textswitcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import app.demo.parallax.R;

public class MyTextSwitchwer extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private TextSwitcher ts = null;
    private String[] str = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_switchwer);
        ts = (TextSwitcher) findViewById(R.id.textswitcher);
        ts.setFactory(this);
    }

    @Override
    public View makeView() {
        TextView textView = new TextView(this);
        textView.setText("example text");
        textView.setShadowLayer(6, 6, 6, Color.BLACK);
        textView.setTextSize(24);
        textView.setTextColor(Color.RED);
        textView.setText(str[counter++]);
        textView.setShadowLayer(6, 6, 6, Color.BLACK);
        return textView;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {

            counter++;
            ts.showNext();
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {

            counter--;
            ts.showPrevious();
        }
        return true;
    }

}
