package ma;

import robocode.*;

public class FirstRobot extends Robot
{
	public void run()
	{
		while(true)
		{
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		fire(1);
	}
}
