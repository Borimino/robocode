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
	}
	
	public void controlGun()
	{
		if(noHitYet)
		{
			turnGunRight(10);
			return;
		}
		timeSinceAim += 1;
		if(onAim)
		{
			return;
		}
		if(timeSinceAim % 2 == 0)
		{
			turnGunRight( (angleOnHit-getRadarHeading()) + timeSinceAim);
		} else {
			turnGunLeft( (angleOnHit-getRadarHeading()) + timeSinceAim);
		}
		onAim = false;
	}
}
