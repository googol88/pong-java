import java.awt.Color;

public class Ball {
  public static final int SIZE = 10;
  
  private int x, y, speed, theta;
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
}