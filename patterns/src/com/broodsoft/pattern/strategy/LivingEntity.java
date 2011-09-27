package com.broodsoft.pattern.strategy;

import com.broodsoft.pattern.strategy.movement.MovementStrategy;
import com.broodsoft.pattern.strategy.reproduction.ReproductionStrategy;

public abstract class LivingEntity
{
	private MovementStrategy movementStrategy;
	private ReproductionStrategy reproductionStrategy;

	protected LivingEntity(MovementStrategy m, ReproductionStrategy r)
	{
		movementStrategy = m;
		reproductionStrategy = r;
	}

	abstract public String type();

	public void move()
	{
		System.out.print(type()+" moving: ");
		movementStrategy.move();
	}

	public void reproduce()
	{
		System.out.print(type()+" reproducing: ");
		reproductionStrategy.reproduce();
	}
}
