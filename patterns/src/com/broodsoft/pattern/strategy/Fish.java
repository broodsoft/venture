package com.broodsoft.pattern.strategy;

import com.broodsoft.pattern.strategy.movement.Swimming;
import com.broodsoft.pattern.strategy.reproduction.SexualReproduction;

public class Fish extends LivingEntity
{
	public Fish()
	{
		super(new Swimming(), new SexualReproduction());
	}

	public String type()
	{
		return "fish";
	}
}