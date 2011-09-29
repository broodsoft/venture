package com.broodsoft.db4o;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.util.FileUtil;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class Db4oDemoLauncher
{
	public static void main(String[] args) throws Exception
	{
		Db4oDemo demo = new Db4oDemo(FileUtil.buildPath("c:","tmp","demo.db4o"));
		demo.reset();
		demo.prepare();
		demo.create();
		demo.finish();
		demo.query();
		demo.finish();
	}
}
