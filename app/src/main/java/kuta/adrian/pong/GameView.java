package kuta.adrian.pong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    16.04.15
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

	public GameThread gameThread;

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		GameState.screenHeight = MeasureSpec.getSize(heightMeasureSpec);
		GameState.screenWidth = MeasureSpec.getSize(widthMeasureSpec);
		GameState.updateGameSettings();
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		setFocusable(true);

		gameThread = new GameThread(holder);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
	                           int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		gameThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		gameThread.stop();
	}
}