package com.broodsoft.pattern.state;

//STATE CONTEXT
public interface FanStateContext
{
	public void pull();

	public FanState getCurrentState();
	public void setCurrentState(FanState state);
}