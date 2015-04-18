package kuta.adrian.pong;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int topBat = -1;
    private int bottomBat = -1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        int index = MotionEventCompat.getActionIndex(event);
        int yPos;

        if (action == MotionEvent.ACTION_UP) {
            topBat = -1;
            bottomBat = -1;
        }
        if (event.getPointerCount() > 1) {
            yPos = (int) MotionEventCompat.getY(event, 0);
            if (topBat == -1 || bottomBat == -1) {
                if (yPos < GameState.screenHeight / 2)
                    topBat = 0;
                else
                    topBat = 1;
                bottomBat = (topBat + 1) % 2;
            }
            GameState.topBatX = (int) MotionEventCompat.getX(event, topBat);
            GameState.bottomBatX = (int) MotionEventCompat.getX(event, bottomBat);

        } else {
            yPos = (int) MotionEventCompat.getY(event, index);
            if (yPos < GameState.screenHeight / 2)
                GameState.topBatX = (int) MotionEventCompat.getX(event, index);
            else
                GameState.bottomBatX = (int) MotionEventCompat.getX(event, index);
        }

        return super.onTouchEvent(event);
    }
}
