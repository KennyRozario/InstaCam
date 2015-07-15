package com.example.kenny.instacam;

import android.util.Log;

import com.facebook.model.GraphObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kenny on 2015-07-15.
 */
public class User {

    private static final String TAG = "User";

    private String mFirstName;
    private String mLastName;
    private String mAvatarURL;
    private Date mBirthday;

    private static User sCurrentUser;

    public static User getCurrentUser() {
        return sCurrentUser;
    }

    public static void setCurrentUser(GraphObject graphObject) {
        if (sCurrentUser == null){
            sCurrentUser = new User(graphObject);
        }
    }

    User (GraphObject graphObject){
        mFirstName = (String) graphObject.getProperty("first_name");
        mLastName = (String) graphObject.getProperty("last_name");
        mAvatarURL = (String) graphObject.getPropertyAs("picture", GraphObject.class)
                .getPropertyAs("data", GraphObject.class)
                .getProperty("url");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            mBirthday = sdf.parse((String) graphObject.getProperty("birthday"));
        } catch (ParseException e) {
            Log.d(TAG, "Failed at parsing date " + graphObject.getProperty("birthday"));
        }
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getAvatarURL() {
        return mAvatarURL;
    }

    public Date getBirthday() {
        return mBirthday;
    }
}
