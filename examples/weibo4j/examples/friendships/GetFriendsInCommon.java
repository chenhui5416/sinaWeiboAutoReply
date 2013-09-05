package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Paging;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFriendsInCommon {

	public static void main(String[] args) {
		String access_token ="2.00Vq3LvBWdJN3E701518924105SbNZ";
		String uid = "1761093415";
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		Paging page =new Paging(2,200);
		try {
			UserWapper users = fm.getFriendsInCommon("1761093415","1761093415",page);
			for(User u : users.getUsers()){
				Log.logInfo(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

	}


