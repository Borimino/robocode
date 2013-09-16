package ma;

import robocode.*;

public class AimBot extends Robot 
{
	private boolean onAim = false;
	private int timeSinceAim = 0;
	private double angleOnHit = 0;
	private boolean noHitYet = true;
	
	public void run()
	{
		while(true)
		{
			System.out.println("Test");
			controlGun();
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		fire(1);
		noHitYet = false;
		onAim = true;
		timeSinceAim = 0;
		angleOnHit = getRadarHeading();
		scan();
	}
	
	public void controlGun()
	{
		turnGunRight(100);
		scan();
		timeSinceAim += 1;
		if(onAim)
		{
			scan();
			onAim = false;
			return;
		}
		onAim = false;
	}
}
