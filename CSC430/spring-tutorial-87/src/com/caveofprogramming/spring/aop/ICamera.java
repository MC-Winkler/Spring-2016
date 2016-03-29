package com.caveofprogramming.spring.aop;

public interface ICamera {

	void snap();

	void snap(int exposure);

	String snap(String name);

	void snapNighttime();

	void snapCar(Car car);

	void snap(double exposure);
	
	public abstract void snap(int i, double d);

}