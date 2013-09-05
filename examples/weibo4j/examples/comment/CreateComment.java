package weibo4j.examples.comment;

import weibo4j.Comments;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Comment;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.Timeline;
public class CreateComment {

	public static void main(String[] args) {
		String access_token = "2.00Yyg4XDWdJN3E3713becddesAgQmD";
		String comments ="哈哈哈哈····";
		String id = "zpFUAw37A";
		Comments cm = new Comments();
		Timeline tm = new Timeline();
		tm.setToken(access_token);
		try {
			try {
				id = (String) tm.QueryId("zpFUAw37A", 1, 0, 1).get("id");
				id="3561828682754457";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (WeiboException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cm.client.setToken(access_token);
		try {
			Comment comment = cm.createComment(comments, id);
			Log.logInfo(comment.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
