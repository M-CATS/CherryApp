package cherry.action.model;

import java.util.List;

public class ViewNews {

	private String newsid;
	private String title;
	private String summary;
	private String imgUrl;
	private String pageUrl;
	private List<ViewTag> newsTags;

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public List<ViewTag> getNewsTags() {
		return newsTags;
	}

	public void setNewsTags(List<ViewTag> newsTags) {
		this.newsTags = newsTags;
	}

}
