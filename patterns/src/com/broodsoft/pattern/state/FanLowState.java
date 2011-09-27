package com.broodsoft.pattern.state;

public class FanLowState implements FanState
{
	@Override
	public void pull(FanStateContext context)
	{
		System.out.println("Was in LOW state. Now in MEDIUM state");
		context.setCurrentState(new FanMediumState());
	}
}