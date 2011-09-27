package com.broodsoft.pattern.strategy;

import com.broodsoft.pattern.strategy.movement.Slithering;
import com.broodsoft.pattern.strategy.reproduction.AsexualReproduction;

public class Worm extends LivingEntity
{
	public Worm()
	{
		super(new Slithering(), new AsexualReproduction());
	}

	public String type()
	{
		return "worm";
	}
}