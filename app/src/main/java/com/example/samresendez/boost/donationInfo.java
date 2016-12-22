package com.example.samresendez.boost;

/**
 * Created by SamResendez on 11/12/16.
 */

public class donationInfo extends Object {

    String mTitle;
    String mDescrip;
    boolean isFiyah;
    String orgId;
    String imgUrl;

    donationInfo(String title,String descrip, String org,String url) {
        mTitle = title;
        mDescrip = descrip;
        isFiyah = false;
        orgId = org;
        imgUrl = url;
    }
}
