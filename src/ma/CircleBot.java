package ma;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.Color;

public class CircleBot extends Robot 
{
	private int time;
	private boolean seen = false;

	/*public CircleBot()
	{
		super();
		time = 0;
		setScanColor(Color.WHITE);
	}*/

	public void run()
	{
		//setScanColor(Color.WHITE);
		while(true)
		{
			moveInCircle(36, 30);
			controlGun();
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		fire(1);
		seen = true;
	}
	
	private void moveInCircle(int sides, int length)
	{
		ahead(length);
		turnRight(360/sides);
	}
	
	private void controlGun()
	{
		if(!seen)
		{
			turnGunRight(36/2);
		}
		seen = false;
	}
}
