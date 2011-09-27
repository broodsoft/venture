package com.broodsoft.pattern.strategy;

import java.util.Collection;
import java.util.LinkedList;

public class World
{
	public static void demo()
	{
		Collection<LivingEntity> entities = new LinkedList<LivingEntity>();
		entities.add(new Fish());
		entities.add(new Human());
		entities.add(new Worm());

		for(LivingEntity entity : entities)
		{
			entity.move();
			entity.reproduce();
		}
	}
}
