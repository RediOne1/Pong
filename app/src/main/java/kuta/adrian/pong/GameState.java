package kuta.adrian.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    16.04.15
 */
public class GameState {

    public static int screenWidth = 300;
    public static int screenHeight = 420;

    final int ballSize = 20;
    int ballX = screenWidth / 2;
    int ballY = screenHeight / 2;
    private int ballVelocityX = 4;
    private int ballVelocityY = 4;

    private static final int batLength = 150;
    private static final int batHeight = 10;
    public static int topBatX = (screenWidth / 2) - (batLength / 2);
    private static int topBatY = 20;
    public static int bottomBatX = (screenWidth / 2) - (batLength / 2);
    private static int bottomBatY = screenHeight - 20;

    public GameState() {
    }

    public static void updateGameSettings() {
        topBatX = (screenWidth / 2) - (batLength / 2);
        topBatY = 20;
        bottomBatX = (screenWidth / 2) - (batLength / 2);
        bottomBatY = screenHeight - 20;
    }

    public void update() {

        ballX += ballVelocityX;
        ballY += ballVelocityY;

        if (ballY > screenHeight || ballY < 0) {
            ballX = screenWidth / 2;
            ballY = screenHeight / 2;
        }

        if (ballX > screenWidth || ballX < 0)
            ballVelocityX *= -1;

        if (ballX > topBatX && ballX < topBatX + batLength && ballY < topBatY)
            ballVelocityY *= -1;

        if (ballX > bottomBatX && ballX < bottomBatX + batLength
                && ballY > bottomBatY)
            ballVelocityY *= -1;
    }

    public void draw(Canvas canvas, Paint paint) {

        canvas.drawRGB(20, 20, 20);

        paint.setARGB(200, 0, 200, 0);

        canvas.drawRect(new Rect(ballX, ballY, ballX + ballSize, ballY + ballSize),
                paint);

        canvas.drawRect(new Rect(topBatX, topBatY, topBatX + batLength,
                topBatY + batHeight), paint); //top bat
        canvas.drawRect(new Rect(bottomBatX, bottomBatY, bottomBatX + batLength,
                bottomBatY + batHeight), paint); //bottom bat

    }
}