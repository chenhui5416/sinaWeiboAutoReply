package mypage;
/**
 * 本类功能获得AccessToken 共后续使用
 */
import java.io.IOException;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

public class accessApiPro {
	private String uId;
	
	private Oauth oauth = new Oauth();
	/**
	 * 打开验证网页获得code
	 * @throws WeiboException
	 * @throws IOException
	 */
	public void getCode () throws WeiboException, IOException
	{	
		BareBonesBrowserLaunch.openURL(oauth.authorize("code","",""));
	}
	/**
	 * 将code转化为AccessToken
	 * @param code
	 * @return accessToken 和 uid
	 */
	public String[] myGetToken (String code)
	{
		AccessToken accessToken;
		String accessTokenStr ="";
		String uId="";
		try{
			accessToken = oauth.getAccessTokenByCode(code);
		//	System.out.println(accessToken);
		//	System.out.println("accessToken For me " +accessToken.getAccessToken());
			accessTokenStr = accessToken.getAccessToken();
			uId = accessToken.uid;
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
			//	Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
		String[] returnStr = {accessTokenStr,uId};
		return returnStr;	
	}
	
	
}
