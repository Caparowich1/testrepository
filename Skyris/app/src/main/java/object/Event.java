package object;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {

    private String name;
    private long startTime, endTime;
    private List<Integer> invitedUsers;
    private Map<Integer, Bitmap> imageBitmapList;
    private Map<Integer, String> imageUrlStrings;

    public Event() {
        invitedUsers = new ArrayList<Integer>();
        imageBitmapList = new HashMap<Integer, Bitmap>();
        imageUrlStrings = new HashMap<Integer, String>();
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setStartTime(long st) {
        startTime = st;
    }

    public void setEndTime(long et) {
        endTime = et;
    }

    public void setInvitedUsers(List<Integer> inv) {
        invitedUsers = inv;
    }

    public void setImageBitmapList(Map<Integer, Bitmap> inv) {
        imageBitmapList = inv;
    }

    public void setImageUrlStrings(Map<Integer, String> inv) {
        imageUrlStrings = inv;
    }


    public String getName() {
        return name;
    }


    public long getStartTime() {
        return startTime;
    }

    public long setEndTime() {
        return endTime;
    }

    public List<Integer> getInvitedUsers() {
        return invitedUsers;
    }

    public Map<Integer, Bitmap> getImageBitmapList() {
        return imageBitmapList;
    }

    public Map<Integer, String> getImageUrlStrings() {
        return imageUrlStrings;
    }




}
