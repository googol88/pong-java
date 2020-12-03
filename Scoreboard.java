import java.awt.Font;

public class Scoreboard {
  public static final Font FONT = new Font("FreeSans Bold Oblique", Font.PLAIN, 36);
  
  private int x, y;
  private Paddle paddle;
  
  public Scoreboard(Paddle paddle) {
    this.paddle = paddle;
    x = paddle.getComputerControlled() ? GamePanel.WIDTH/4 - 18 : 3*GamePanel.WIDTH/4 - 18;
    y = 75;
  }

  public void render(Graphics g) {
    g.setColor(paddle.getColor());
    g.setFont(FONT);
    g.drawString(Integer.toString(paddle.getScore()), this.x, this.y);
  }
}