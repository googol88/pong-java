import java.swing.JFrame;

public class Main extends JFrame{

  public Main() {
    setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GamePanel pongBoard = new GamePanel();
    add(pongBoard);
  }
  public static void main(String[] args) {
    // test out constructors here
    Main game = new Main();
    game.setVisible(true);
  }
}