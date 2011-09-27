package com.broodsoft.pattern.strategy.movement;

public class Walking implements MovementStrategy
{
	@Override
	public void move()
	{
		System.out.println("walking");
	}
}
