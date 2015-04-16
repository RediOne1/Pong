package kuta.adrian.pong;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {


    private Button left, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        left.setOnTouchListener(this);
        right.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v == left) {
                GameState.keyPressed(GameState.LEFT);
            } else if (v == right) {
                GameState.keyPressed(GameState.RIGHT);
            }
            return true;
        }
        return false;
    }
}