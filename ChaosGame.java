import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class ChaosGame extends JPanel{
	final int size = 3;

	//Double buffering feature of paintComponent 
	//makes for quicker animation than paint
	public void paintComponent(Graphics g)  
	{
		Random r  = new Random();

		super.paintComponent(g);

		//First create corner point objects
		Point[] corners = new Point[3];
		corners[0] = new Point(50,30);
		corners[1] = new Point(350, 30);
		corners[2] = new Point(200, 300);

		//draw red circles for corners
		g.setColor(Color.red);
		g.fillOval(corners[0].getX(), corners[0].getY(), size, size);
		g.fillOval(corners[1].getX(), corners[1].getY(), size, size);
		g.fillOval(corners[2].getX(), corners[2].getY(), size, size);

		//Create player point, set to random starting location
		Point p = new Point(r.nextInt(400), r.nextInt(400));
		g.setColor(Color.BLUE);

		int temp = 0;
		//begin main loop. during each iteration, choose random corner to move half 
		//the distance toward and place a point at that location
		for (int i = 0; i < 20000; i++) {
			g.fillOval(p.getX(), p.getY(), size, size); //draw new point
			//choose one of the corners to move toward, reset p's x and y
			temp = r.nextInt(3); //generate random int in [0, 2]
			p.setX((corners[temp].getX()+p.getX())/2);
			p.setY((corners[temp].getY()+p.getY())/2);
			sleep(10);
		}
	}


	public void sleep(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
