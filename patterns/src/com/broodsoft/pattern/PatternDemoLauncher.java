package com.broodsoft.pattern;

import com.broodsoft.pattern.state.Client;
import com.broodsoft.pattern.strategy.World;

public class PatternDemoLauncher
{
	public static void main(String[] args)
	{
		launchStatePatternDemo();
		launchStrategyPatternDemo();
	}

	public static void launchStatePatternDemo(){ Client.demo(); }
	public static void launchStrategyPatternDemo(){ World.demo(); }
}
