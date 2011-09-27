package com.broodsoft.pattern.state;

//CLIENT
public class Client
{
	public static void demo()
	{
		FanStateContext ctx = new CeilingFan();
		ctx.pull();
		ctx.pull();
		ctx.pull();
		ctx.pull();
	}
}
