package com.broodsoft.pattern.state;

public class FanOffState implements FanState
{
	@Override
	public void pull(FanStateContext context)
	{
		System.out.println("Was in OFF state. Now in LOW state");
		context.setCurrentState(new FanLowState());
	}
}