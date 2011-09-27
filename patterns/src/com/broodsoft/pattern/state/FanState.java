package com.broodsoft.pattern.state;

//ABSTRACT STATE
public interface FanState
{
	/* Specifies the same action method as the CONTEXT, with the exception
	 * that a reference to the CONTEXT is passed in as an argument.
	 * Once the appropriate logic for this action (in this state) is performed
	 * the CONTEXT's current state is updated to the next logical state, that is
	 * each state implementing this interface needs to be aware of the state that
	 * follows it
	 */
	public void pull(FanStateContext context);
}
