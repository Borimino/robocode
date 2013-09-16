package ma;

import robocode.*;

public class FirstRobot extends Robot
{
	public void run()
	{
		while(true)
		{
			moveInFractal(3, 1000);
			turnRight(60);
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		fire(1);
	}
	
	private void moveInFractal(int n, int length)
	{
		if(n == 0)
		{
			ahead(length);
		} else
		{
			moveInFractal(n-1, length/3);
			turnRight(60);
			moveInFractal(n-1, length/3);
			turnRight(-120);
			moveInFractal(n-1, length/3);
			turnRight(60);
			moveInFractal(n-1, length/3);
		}
	}
}
