package com.broodsoft.pattern.state;

public class FanHighState implements FanState
{
	@Override
	public void pull(FanStateContext context)
	{
		System.out.println("Was in HIGH state. Now turning OFF");
		context.setCurrentState(new FanOffState());
	}
}