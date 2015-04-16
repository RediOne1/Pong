package kuta.adrian.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceHolder;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    16.04.15
 */
public class GameThread extends Thread {

    /**
     * Handle to the surface manager object we interact with
     */
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private GameState gameState;

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        paint = new Paint();
        gameState = new GameState();
    }

    @Override
    public void run() {
        while (true) {
            Canvas canvas = surfaceHolder.lockCanvas();
            gameState.update();
            gameState.draw(canvas, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}