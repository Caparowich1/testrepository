package object;

import android.graphics.Bitmap;

/**
 * Created by Octane on 3/2/2016.
 */
public class Friend {

    public String username;
    public String imageUrl;
    public Bitmap image;
    public Integer userID;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setImageUrl(String img) {
        this.imageUrl = img;
    }

    public void setBitmap(Bitmap bmp) {
        this.image = bmp;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Bitmap getImage() {
        return image;
    }

    public Integer getUserID() {
        return userID;
    }

}
