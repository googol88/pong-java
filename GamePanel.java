import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel{
  // use this class to store constants about the Pong gameboard dimensions.
  public static final int WIDTH = 720;
  public static final int HEIGHT = 600;
  public static final int X_GAP = 50;

  // colors
  public static final Color LP_CLR = new Color(0, 255, 0);
  public static final Color RP_CLR = new Color(0, 0, 255);
  public static final Color B_CLR  = new Color(255, 0, 0);

  // attributes
  private Paddle leftPanel, rightPanel;
  private Scoreboard leftScoreboard, rightScoreboard;
  private Ball ball;

  // constructor
  public GamePanel() {
    setSize(WIDTH, HEIGHT);
    leftPanel = new Paddle(LP_CLR);
    rightPanel = new Paddle(false, RP_CLR);
    leftScoreboard = new Scoreboard(leftPanel);
    rightScoreboard = new Scoreboard(rightPanel);
    ball = new Ball(B_CLR);
  }

  
}