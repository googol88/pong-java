import java.awt.Color;
import java.awt.Graphics;

public class Ball {
  public static final int SIZE = 10;
  
  private int x, y, speed, theta; // theta is in degrees
  private Color color;

  public Ball() {
    x = GamePanel.WIDTH/2 - SIZE/2;
    y = GamePanel.HEIGHT/2 - SIZE/2;
    theta = generateThetaValue();
    speed = 3;
    color = new Color(255, 255, 255);
  }

  public Ball(Color color) {
    x = GamePanel.WIDTH/2 - SIZE/2;
    y = GamePanel.HEIGHT/2 - SIZE/2;
    theta = generateThetaValue();
    speed = 3;
    this.color = color;
  }

  public Ball(int theta) {
    x = GamePanel.WIDTH/2 - SIZE/2;
    y = GamePanel.HEIGHT/2 - SIZE/2;
    this.theta = theta % 360;
    speed = 3;
    color = new Color(255, 255, 255);
  }

  public Ball(int theta, Color color) {
    x = GamePanel.WIDTH/2 - SIZE/2;
    y = GamePanel.HEIGHT/2 - SIZE/2;
    this.theta = theta % 360;
    speed = 3;
    this.color = color;
  }
  
  // helper methods can be private
  private static int generateThetaValue() {
    int randTheta = (int) (Math.random() * 338); // 0-84 -> 85, 96-264 -> 169, 276-359 -> 84 = [338]
    if (randTheta >= 85) {
      randTheta += 11;
    }
    if (randTheta >= 265) {
      randTheta += 11;
    }
    return randTheta;
  }

  public void render(Graphics g) {
    g.setColor(this.color); // the instance's attribute/state
    g.fillRect(this.x, this.y, SIZE, SIZE);
  }

  public void move() {
    this.x += speed * Math.cos(Math.toRadians(theta));
    this.y -= speed * Math.sin(Math.toRadians(theta)); // since increasing y values go downward
  }

  // getters
  public int getX() {
    return this.x;
  }
  public int getY() {
    return this.y;
  }
  public int getTheta() {
    return this.theta;
  }

  // setters
  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }
  public void setTheta(int theta) {
    this.theta = theta;
  }
}