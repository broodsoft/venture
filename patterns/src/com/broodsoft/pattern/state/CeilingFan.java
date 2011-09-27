package com.broodsoft.pattern.state;

public class CeilingFan implements FanStateContext
{
	private FanState currentState;

	public CeilingFan()
	{
		currentState = new FanOffState();
	}

	public void pull()
	{
		currentState.pull(this);
	}

	public FanState getCurrentState()
	{
		return currentState;
	}

	public void setCurrentState(FanState state)
	{
		currentState = state;
	}
}
