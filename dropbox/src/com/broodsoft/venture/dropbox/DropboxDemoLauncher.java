package com.broodsoft.venture.dropbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DropBoxApi;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.util.CharsetUtil;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.RequestTokenPair;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;

@CodeAuthor(first = "Andrey", last = "Yamshchikov")
public class DropboxDemoLauncher
{
	private static final String APP_KEY = "62zxmb43lbd2zmm";
	private static final String APP_SECRET = "fy5k8jwrzmzbu8x";

	public static void main(String[] args) throws Exception
	{
//		byte[] data = "01234567891234567890".getBytes(CharsetUtil.UTF8);
//
//		FileOutputStream fos = new FileOutputStream("C:/test.raw");
//		fos.write(data);
//		fos.close();
//
//		FileInputStream fis = new FileInputStream("C:/test.raw");
//		BOMInputStream bomIs = new BOMInputStream(fis, ByteOrderMark.UTF_8);
//		byte[] fileData = IOUtils.toByteArray(fis);
//		System.out.println(new String(fileData, CharsetUtil.UTF8));

		AppKeyPair keyPair = new AppKeyPair(APP_KEY, APP_SECRET);
		WebAuthSession session = new WebAuthSession(keyPair, AccessType.APP_FOLDER);
		DropboxAPI<WebAuthSession> api = new DropboxAPI<WebAuthSession>(session);
		WebAuthInfo authInfo = api.getSession().getAuthInfo();
		String authKey = authInfo.requestTokenPair.key;
		String authSecret = authInfo.requestTokenPair.secret;
		String authUrl = authInfo.url;
		System.out.printf
		(
			"Key: '%1$s'\n" +
			"Secret: '%2$s'\n" +
			"URL: '%3$s'\n",
			authKey, authSecret, authUrl
		);
		
		
		
		Scanner input = new Scanner(System.in);
		String token= input.nextLine();
		System.out.println(token);
		api.getSession().retrieveWebAccessToken(new RequestTokenPair(authKey, authSecret));

		byte[] data = "this is a test".getBytes(CharsetUtil.UTF8);
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		api.putFile("test.raw", bais, data.length, null, null);
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		api.getFile("test.raw", null, baos, null);
		System.out.println(new String(baos.toByteArray(), CharsetUtil.UTF8));
		System.out.println("done");
	}
}