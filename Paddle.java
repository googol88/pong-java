import java.awt.Color;
import java.awt.Graphics;

public class Paddle{
  // common across class
  public static final int WIDTH = 15;
  public static final int HEIGHT = 50;
  // attributes (state)
  private int x;
  private int y;
  private int score;
  private int speed;
  private boolean computerControlled;
  private Color color;
  
  // constructor(s)
  // no return type, name matches class (uppercase)
  public Paddle() {
    x = GamePanel.X_GAP;
    y = GamePanel.HEIGHT/2 - HEIGHT/2; // vertically align paddle (275)
    score = 0;
    speed = 5;
    computerControlled = true;
    color = new Color(255, 255, 255);
  }
  public Paddle(Color color) {
    x = GamePanel.X_GAP;
    y = GamePanel.HEIGHT/2 - HEIGHT/2; // vertically align paddle (275)
    score = 0;
    speed = 5;
    computerControlled = true;
    // "this" refers to attribute color, not parameter
    this.color = color;
  }
  public Paddle(boolean computerControlled) {
    x = computerControlled ? GamePanel.X_GAP : GamePanel.WIDTH - (GamePanel.X_GAP + WIDTH); // move to right if NOT computer controlled
    y = GamePanel.HEIGHT/2 - HEIGHT/2; // vertically align paddle (275)
    score = 0;
    speed = 5;
    this.computerControlled = computerControlled;
    color = new Color(255, 255, 255);
  }
  public Paddle(boolean computerControlled, Color color) {
    x = computerControlled ? GamePanel.X_GAP : GamePanel.WIDTH - (GamePanel.X_GAP + WIDTH);
    y = GamePanel.HEIGHT/2 - HEIGHT/2; // vertically align paddle (275)
    score = 0;
    speed = 5;
    this.computerControlled = computerControlled;
    this.color = color;
  }

  // methods (behavior)
  public void render(Graphics g) {
    g.setColor(this.color); // the instance's attribute/state
    g.fillRect(this.x, this.y, WIDTH, HEIGHT);
  }

  public boolean isControlled() {
    return this.computerControlled; // again, the instance's attribute/state
  }
}