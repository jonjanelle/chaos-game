import javax.swing.*;
public class ChaosRunner {

	public static void main(String[] args) {
		JFrame gw = new JFrame();
		gw.setSize(400, 400);
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setVisible(true);
		
		ChaosGame gamePanel = new ChaosGame();
		gw.add(gamePanel);

	}

}
