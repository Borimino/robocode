package ma;
import java.util.ArrayList;

import robocode.Robot;
import robocode.ScannedRobotEvent;


public class PredictoBot extends Robot 
{
	private boolean onAim = false;
	private ArrayList<Coords> coords = new ArrayList<Coords>();

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
		onAim = true;
		stop();
		coords.add(new Coords(getRadarHeading(), e.getDistance(), e.getVelocity(), e.getHeading()));
	}
	
	public void controlGun()
	{
		if(onAim)
		{
			fire(1);
			onAim = false;
			scan();
			return;
		}
		correctAim();
	}
	
	public void correctAim()
	{
		if(coords.size() >= 1)
		{
			turnTo(predictNextPos());
		} else
		{
			turnGunRight(45);
		}
	}
	
	public double predictNextPos()
	{
		Coords tmp = coords.get(coords.size()-1);
		double x = tmp.getDist() * Math.cos(tmp.getDegree());
		double y = tmp.getDist() * Math.sin(tmp.getDegree());
		double nX = x + tmp.getVel()*Math.cos(tmp.getDir());
		double nY = y + tmp.getVel()*Math.sin(tmp.getDir());
//		double dist = Math.sqrt(nX*nX + nY*nY);
		double dir = Math.atan2(nY, nX);
		return dir;
	}
	
	public void turnTo(double d)
	{
		turnGunRight(d - getRadarHeading());
	}
	
	private class Coords
	{
		private double degree;
		private double dist;
		private double vel;
		private double dir;
		
		public Coords(double degree, double dist, double vel, double dir)
		{
			this.degree = degree;
			this.dist = dist;
			this.vel = vel;
			this.dir = dir;
		}
		
		public double getDegree()
		{
			return degree;
		}
		
		public double getDist()
		{
			return dist;
		}
		
		public double getVel()
		{
			return vel;
		}
		
		public double getDir()
		{
			return dir;
		}
		
		/*
		public void setDegree(double d)
		{
			degree = d;
		}
		
		public void setDist(double d)
		{
			dist = d;
		}
		
		public void setVel(double d)
		{
			vel = d;
		}
		
		public void setDir(double d)
		{
			dir = d;
		}
		*/
	}
}