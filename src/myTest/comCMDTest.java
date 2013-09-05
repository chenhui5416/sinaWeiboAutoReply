package myTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import mypage.FriendMes;
import mypage.accessApiPro;
import mypage.userMes;
public class comCMDTest {
	public  static void main(String args[]) throws IOException
	{

		accessApiPro comCmd = new accessApiPro();
		try {
			comCmd.getCode();
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Log.logInfo("code: " + code);
		String[] returnStr= comCmd.myGetToken(code);
		System.out.println(returnStr[0]);
		System.out.print(returnStr[1]);
		userMes usermes = new userMes(returnStr[0],"3241664330");
		System.out.println("昵称"+usermes.getuName()+"关注数"+usermes.getFriendNum()+"粉丝数"+usermes.getFllowedNum());
		FriendMes friend = new FriendMes();
		
		friend.giveReply(returnStr[0], "3561936245434681", "捶捶···");
	}
}
