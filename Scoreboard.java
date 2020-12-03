import java.awt.Font;

public class Scoreboard {
  public static final Font FONT = new Font("FreeSans Bold Oblique", Font.PLAIN, 36);
  
  private int x, y;
  private Paddle paddle;
  
  public Scoreboard(Paddle paddle) {
    this.paddle = paddle;
    x = 150;
    y = 75;
    if(paddle.isControlled()) {
      x = GamePanel.WIDTH/4 - 18;
    } else {
      x = 3*GamePanel.WIDTH/4 - 18;
    }
  }
}