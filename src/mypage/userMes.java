package mypage;
/**
 * 本类用于获得 授权用户的信息
 */
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import mypage.accessApiPro;

public class userMes {

	private String uName;
	private int fllowedNum;
	private int friendNum;
	/**
	 * 构造函数，输入accessToken 、uId，获得相应用户的信息
	 * @param accessToken
	 * @param uId
	 * 获取方式，使用get**()方法。
	 */
	public userMes(String accessToken,String uId)
	{
		String access_token = accessToken;
		String uid =uId;
		Users um = new Users();
		um.client.setToken(access_token);
		try {
			User user = um.showUserById(uid);
			this.uName = user.getScreenName();
			this.fllowedNum = user.getFollowersCount();
			this.friendNum = user.getFriendsCount();
		//	Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getFllowedNum() {
		return fllowedNum;
	}
	public void setFllowedNum(int fllowedNum) {
		this.fllowedNum = fllowedNum;
	}
	public int getFriendNum() {
		return friendNum;
	}
	public void setFriendNum(int friendNum) {
		this.friendNum = friendNum;
	}
}
