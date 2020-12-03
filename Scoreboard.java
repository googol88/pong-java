import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

public class Scoreboard {
  // font constants
  public static final Font FONT = new Font("FreeSans Bold Oblique", Font.PLAIN, 64);
  
  // attributes
  private int x, y;
  private Paddle paddle;
  
  // constructors
  public Scoreboard(Paddle paddle) {
    this.paddle = paddle;
    x = paddle.getComputerControlled() ? GamePanel.WIDTH/4 - 32 : 3*GamePanel.WIDTH/4 - 32;
    y = 100;
  }

  // methods
  public void render(Graphics g) {
    g.setColor(paddle.getColor());
    g.setFont(FONT);
    g.drawString(Integer.toString(paddle.getScore()), this.x, this.y);
  }
}