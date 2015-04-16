package kuta.adrian.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    16.04.15
 */
public class GameState {

    //screen width and height
    public static int screenWidth = 300;
    public static int screenHeight = 420;

    final static int LEFT = 1;
    final static int RIGHT = 2;

    //The ball
    final int ballSize = 10;
    int ballX = screenWidth / 2;
    int ballY = screenHeight / 2;
    private int ballVelocityX = 3;
    private int ballVelocityY = 3;

    //The bats
    private static final int batLength = 75;
    private static final int batHeight = 10;
    private static int topBatX = (screenWidth / 2) - (batLength / 2);
    private static int topBatY = 20;
    private static int bottomBatX = (screenWidth / 2) - (batLength / 2);
    private static int bottomBatY = screenHeight - 20;
    private static final int batSpeed = 30;

    public GameState() {
    }

    public static void updateGameSettings() {
        topBatX = (screenWidth / 2) - (batLength / 2);
        topBatY = 20;
        bottomBatX = (screenWidth / 2) - (batLength / 2);
        bottomBatY = screenHeight - 20;
    }

    //The update method
    public void update() {

        ballX += ballVelocityX;
        ballY += ballVelocityY;

        //DEATH!
        if (ballY > screenHeight || ballY < 0) {
            ballX = screenWidth / 2;
            ballY = screenHeight / 2;
        }    //Collisions with the sides

        if (ballX > screenWidth || ballX < 0)
            ballVelocityX *= -1;    //Collisions with the bats

        if (ballX > topBatX && ballX < topBatX + batLength && ballY < topBatY)
            ballVelocityY *= -1;  //Collisions with the bats

        if (ballX > bottomBatX && ballX < bottomBatX + batLength
                && ballY > bottomBatY)
            ballVelocityY *= -1;
    }

    public static void keyPressed(int direction) {
        if (direction == LEFT) //left
        {
            topBatX += batSpeed;
            bottomBatX -= batSpeed;
        }

        if (direction == RIGHT) //right
        {
            topBatX -= batSpeed;
            bottomBatX += batSpeed;
        }
    }

    //the draw method
    public void draw(Canvas canvas, Paint paint) {

        //Clear the screen
        canvas.drawRGB(20, 20, 20);

        //set the colour
        paint.setARGB(200, 0, 200, 0);

        //draw the ball
        canvas.drawRect(new Rect(ballX, ballY, ballX + ballSize, ballY + ballSize),
                paint);

        //draw the bats
        canvas.drawRect(new Rect(topBatX, topBatY, topBatX + batLength,
                topBatY + batHeight), paint); //top bat
        canvas.drawRect(new Rect(bottomBatX, bottomBatY, bottomBatX + batLength,
                bottomBatY + batHeight), paint); //bottom bat

    }
}