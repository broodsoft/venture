package com.broodsoft.pattern.state;

public class FanMediumState implements FanState
{
	@Override
	public void pull(FanStateContext context)
	{
		System.out.println("Was in MEDIUM state. Now in HIGH state");
		context.setCurrentState(new FanHighState());
	}
}