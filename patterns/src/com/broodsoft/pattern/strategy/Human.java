package com.broodsoft.pattern.strategy;

import com.broodsoft.pattern.strategy.movement.Walking;
import com.broodsoft.pattern.strategy.reproduction.SexualReproduction;

public class Human extends LivingEntity
{
	public Human()
	{
		super(new Walking(), new SexualReproduction());
	}

	public String type()
	{
		return "human";
	}
}
