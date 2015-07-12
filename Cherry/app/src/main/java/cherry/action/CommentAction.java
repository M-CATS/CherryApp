package cherry.action;

<<<<<<< HEAD
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

=======
import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpResponseHandler;

>>>>>>> origin/master
import cherry.action.util.ActionBase;
import cherry.action.util.CherryClient;
import cherry.action.util.Responser;

<<<<<<< HEAD
=======
// ÓÃ»§ÆÀÂÛ
>>>>>>> origin/master
public class CommentAction extends ActionBase {

	public CommentAction(String userid, String newsid, String comment) {
		this.relativeUrl = "/response/comment";
		this.params.put("userid", userid);
		this.params.put("newsid", newsid);
		this.params.put("commentContent", comment);
	}
	
	@Override
	public void execute(final Responser responser) {
		// TODO Auto-generated method stub
		CherryClient.post(relativeUrl, params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				responser.successfulResponse(new String(arg2));
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				responser.failedResponse(arg3.getMessage());
			}
		});
	}

}
