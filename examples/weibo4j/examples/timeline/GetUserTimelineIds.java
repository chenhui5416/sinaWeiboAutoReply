package weibo4j.examples.timeline;

import java.util.ArrayList;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class GetUserTimelineIds {
	public static void main(String[] args) {
		String access_token = "2.00Yyg4XDWdJN3E3713becddesAgQmD";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			JSONObject ids = tm.getUserTimelineIdsByUid("3167081372");
			try {
				JSONArray status =  (JSONArray) ids.get("statuses");
				
				System.out.println("我打印出来的："+status.getString(0)+"我打印结束的");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.logInfo(ids.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
