package com.manikandansethuraj.nepeancricketclub;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ManikandanSethuraj on 2016-02-29.
 */
public class FbApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        printhashkey();
    }

    public void printhashkey (){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.manikandansethuraj.nepeancricketclub",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash for FB APP :", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("name not found", e.toString());

        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());

        }

    }
}
