package com.shaadi.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import com.shaadi.R;

import java.util.Random;


/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public class AppUtils {



    /**
     * @return a random generated string
     */
    public static String random() {
        int MAX_LENGTH = 20;
        String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(MAX_LENGTH);
        for (int i = 0; i < MAX_LENGTH; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }


}
