package com.example.officialandroid.img;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import com.example.officialandroid.R;

/**
 * Create by lxx
 * Date : 2021/2/22 14:11
 * Use by
 */
public class Util {

    /**
     * byte -> bitmap
     *
     * @param b
     * @return
     */
    private Bitmap bytes2Bitmap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    /**
     * 资源文件转 bitmap
     *
     * @param context
     * @return
     */
    private Bitmap res2Bitmap(Context context) {
        Resources res = context.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.ic_launcher_background);
        return bmp;
    }

    /**
     * Drawable  Bitmap
     * @param drawable
     * @return
     */
    private Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        //canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
