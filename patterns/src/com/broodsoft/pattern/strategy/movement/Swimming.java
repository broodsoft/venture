package com.broodsoft.pattern.strategy.movement;

public class Swimming implements MovementStrategy
{
	@Override
	public void move()
	{
		System.out.println("swimming");
	}
}
