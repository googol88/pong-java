import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements ActionListener {
  // use this class to store constants about the Pong gameboard dimensions.
  public static final int WIDTH = 720;
  public static final int HEIGHT = 600;
  public static final int X_GAP = 50;
  public static final int Y_GAP = 20;
  public static final int DASH_LEN = 18;

  // colors
  public static final Color LP_CLR = new Color(71, 71, 235);
  public static final Color RP_CLR = new Color(235, 71, 153);
  public static final Color B_CLR  = new Color(194, 71, 235);
  public static final Color BG_CLR = new Color(54, 46, 56);
  public static final Color LINE_CLR = new Color(108, 92, 112);

  // attributes
  private Paddle leftPaddle, rightPaddle;
  private Scoreboard leftScoreboard, rightScoreboard;
  private Ball ball;
  private Timer timer;

  // constructor
  public GamePanel() {
    setSize(WIDTH, HEIGHT);
    setBackground(BG_CLR);
    leftPaddle = new Paddle(true, LP_CLR);
    rightPaddle = new Paddle(false, RP_CLR);
    leftScoreboard = new Scoreboard(leftPaddle);
    rightScoreboard = new Scoreboard(rightPaddle);
    ball = new Ball(0 B_CLR); // temporarily force angle to 0 degrees
    timer = new Timer(30, this);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
	  drawBackground(g);
    leftPaddle.render(g); // call Graphics methods from Paddle class
    rightPaddle.render(g);
    ball.render(g);
    leftScoreboard.render(g);
    rightScoreboard.render(g);
  }

  @Override
  public void actionPerformed(ActionEvent e){
    leftPaddle.move();
    ball.move();
    repaint();
    if (this.checkPaddleCollision()) {
      ball.setTheta((180 + 360*(ball.getTheta()/180) - ball.getTheta()) % 360);
    }
    this.updateScore();
  }
  
  private void drawBackground(Graphics g) {
	  g.setColor(LINE_CLR);
	  for(int y = Y_GAP; y < HEIGHT; y += 2*DASH_LEN) {
		  g.drawLine(WIDTH/2, y, WIDTH/2, y+20);
	  }
  }

  private boolean checkPaddleCollision() { // this.checkPaddleCollision
    // leftPaddle
    if((ball.getX() < leftPaddle.getX() + Paddle.WIDTH) // left of ball, right of leftPaddle
        && (ball.getX() > leftPaddle.getX()) // left of ball still right of paddle's left
        && (ball.getY() < leftPaddle.getY() + Paddle.HEIGHT) // top of ball, bottom of leftPaddle
        && (ball.getY() + Ball.SIZE > leftPaddle.getY())) // bottom of ball, top of leftPaddle
    {
      return true;
    }

    // rightPaddle
    else if ((ball.getX() + Ball.SIZE > rightPaddle.getX()) // right of ball, left of rightPaddle
        && (ball.getX() + Ball.SIZE < rightPaddle.getX() + Paddle.WIDTH) // right of ball still left of paddle's right
        && (ball.getY() < rightPaddle.getY() + Paddle.HEIGHT) // top of ball, bottom of leftPaddle
        && (ball.getY() + Ball.SIZE > rightPaddle.getY())) // bottom of ball, top of rightPaddle
    {
      return true;
    }

    return false;
  }

  private void updateScore() {
    if (ball.getX() + Ball.SIZE < 0) {
      rightPaddle.setScore(rightPaddle.getScore()+1);
      this.reset(); 
    } else if (ball.getX() > WIDTH) {
      leftPaddle.setScore(leftPaddle.getScore()+1);
      this.reset();
    }
  }

  private void reset() {
    ball.setX(GamePanel.WIDTH/2 - Ball.SIZE/2);
    ball.setY(GamePanel.HEIGHT/2 - Ball.SIZE/2);
  }
}