package mypage;
import java.util.ArrayList;
import java.util.List;

import weibo4j.Comments;
import weibo4j.Friendships;
import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Comment;
import weibo4j.model.Paging;
import weibo4j.model.Status;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class FriendMes {
	/**
	 * 获得关注列表
	 * @param accessToken
	 * @param uId
	 * @return 关注好友额信息组 UserWapper
	 */
	public List<User> getFriendList(String accessToken,String uId)
	{
		List<User> retList = new ArrayList();
		String access_token = accessToken;
		String id = uId;
		UserWapper users = null;
		int pageNum =1;
		Paging page = new Paging(pageNum,200);
		Friendships fm = new Friendships();
		int totalNum =0;
		fm.client.setToken(access_token);
		try {
			do{
			users = fm.getFriendsInCommon(uId,uId,page);
			totalNum = (int)users.getTotalNumber();
			for(User u : users.getUsers())
			{
				retList.add(u);
			}
			pageNum++;
			page.setPage(pageNum);
	//		System.out.println(totalNum>200*pageNum);
	//		System.out.println(totalNum);
		//	System.out.println(200*pageNum);  //这个需要继续测试，先写下一个功能····
			
			}while(totalNum>200*(pageNum-1));
		//	System.out.print(totalNum);
			
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		return retList;
	}
	/**
	 * 根据相关信息，给指定用户的指定微博进行评论
	 * @param accessToken
	 * @param statusId
	 * @param comments
	 */
	public void giveReply(String accessToken,String statusId,String comments)
	{
		
	
		Comments cm = new Comments();
		Timeline tm = new Timeline();
		tm.setToken(accessToken);
	
		cm.client.setToken(accessToken);
		try {
			Comment comment = cm.createComment(comments, statusId);
		//	Log.logInfo(comment.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回用户最新发布的微博id列表
	 * @param accessToken
	 * @param uId
	 * @return JSONArray格式
	 */
	public String GetFriendStatusIds(String accessToken,String screeName)
	{
		Timeline tm = new Timeline();
		String sta="" ;
		tm.client.setToken(accessToken);
		JSONArray status = null;
		try {
			JSONObject ids = tm.getUserTimelineIdsByName(screeName);
			try {
				status =  (JSONArray) ids.get("statuses");	
			//	System.out.println("status::::"+status.toString());
				sta = (String) status.get(0);
			//	System.out.println("sta::::"+sta.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return sta;
	}
}
