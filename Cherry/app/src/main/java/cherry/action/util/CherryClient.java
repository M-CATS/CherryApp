package cherry.action.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public abstract class CherryClient {

<<<<<<< HEAD
	private static final String BASE_URL = "http://10.66.27.8:9000";
=======
	private static final String BASE_URL = "http://192.168.1.106:9000";
>>>>>>> origin/master

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), responseHandler);
	}

	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}

}
