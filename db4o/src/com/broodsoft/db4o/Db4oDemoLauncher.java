package com.broodsoft.db4o;

import java.nio.charset.Charset;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.util.EncodingUtil;
import com.broodsoft.brew.util.FileUtil;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class Db4oDemoLauncher
{
	public static void main(String[] args) throws Exception
	{
		Charset ascii = Charset.forName("US-ASCII");
		Charset utf8 = Charset.forName("UTF-8");
		String hexText = "68656c6c6f20776f726c6421";
		byte[] hexData = hexText.getBytes(utf8);
		hexText = new String(hexData, utf8);
		System.exit(0);

		Db4oDemo demo = new Db4oDemo(FileUtil.buildPath("c:","tmp","demo.db4o"));
//		demo.reset();
		demo.prepare();
//		demo.create();
		demo.query();
		demo.finish();
	}
}
