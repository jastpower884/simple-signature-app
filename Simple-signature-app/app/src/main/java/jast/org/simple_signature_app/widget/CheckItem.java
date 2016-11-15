package jast.org.simple_signature_app.widget;

/**
 * Created by jast.lai on 2016/6/13.
 */
public class CheckItem {

    public static final int STATUS_OK = 1;
    public static final int STATUS_NO_CHOOSE = 0;
    public static final int STATUS_NO = -1;


    long _id;
    int status = STATUS_NO_CHOOSE;
    final String check_id;
    final String _store_id;
    String title;
    String description;
    String timestamp;

    String imageUrl = "";
    String commentContent = "";
    String videoUrl = "";

    public CheckItem(String check_id, String _store_id, String title, String description,
                     String timestamp, String imageUrl, String commentContent, String videoUrl, int status) {
        this.check_id = check_id;
        this._store_id = _store_id;
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        this.commentContent = commentContent;
        this.videoUrl = videoUrl;
        this.status = status;

    }

    public String getCheckId() {
        return check_id;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public long getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStoreId() {
        return _store_id;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
