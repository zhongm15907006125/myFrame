package com.yscoco.myframe.helper;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;


import com.yscoco.myframe.App;
import com.yscoco.myframe.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by Munch on 2019/4/1 15:34.
 */
public class ResHelper {

    private ResHelper() {
    }

    private static String getStr(@StringRes int resId) {
        return App.getInstance().getString(resId);
    }

    public static String getString(@StringRes int resId) {
        return getStr(resId);
    }


    public static int getColor(@ColorRes int resId) {
        return ContextCompat.getColor(App.getInstance(), resId);
    }


    public static Drawable getDrawable(@DrawableRes int resId) {
        return ContextCompat.getDrawable(App.getInstance(), resId);
    }

    public static String[] getStrArray(@ArrayRes int arrayResId) {
        return App.getInstance().getResources().getStringArray(arrayResId);
    }

    public static List<String> getStrList(@ArrayRes int arrayResId) {
        return Arrays.asList(getStrArray(arrayResId));
    }

    public static int[] getIntArray(@ArrayRes int arrayResId) {
        return App.getInstance().getResources().getIntArray(arrayResId);
    }

    /**
     * 获取Resources中保存的资源id文件
     */
    public static int[] getIdArray(@ArrayRes int arrayResId) {
        TypedArray array = App.getInstance().getResources().obtainTypedArray(arrayResId);
        int length = array.length();
        int[] ids = new int[length];
        for (int i = 0; i < length; i++) {
            ids[i] = array.getResourceId(i, 0);
        }
        array.recycle();
        return ids;
    }

    public static int getDimen(@DimenRes int dimRes) {
        return App.getInstance().getResources().getDimensionPixelOffset(dimRes);
    }

    public static int dp2Px(float dpValue) {
        float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2Dp(float pxValue) {
        float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 同一姓名下的所有号码都会被读取到
     *
     * @return 为null则读取失败，为空则没有数据
     */
    @Nullable
    public static List<String[]> readContacts(Context context) {
        List<String[]> contacts = new ArrayList<>();
        //资源自动管理
        try (Cursor cursor = context.getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)) {
            //cursor指针 query询问 contract协议 kinds种类
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    number = formatPhoneNum(number);
                    contacts.add(new String[]{displayName, number});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return contacts;
    }

    /**
     * 去掉手机号内除数字外的所有字符
     */
    public static String formatPhoneNum(String phoneNum) {
        String regex = "(\\+86)|[^0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.replaceAll("");
    }

    public static void callPhone(Context context, String phone) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    public static void setNet(Context context) {
        context.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
    }

}