package com.sigaritus.swu.playimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2015/5/9.
 */
public class ImageHelper  {
    public static Bitmap handleImage(Bitmap bitmap,float hue,float saturation,float lum){
        Bitmap bitmap_cpoy = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap_cpoy);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();

        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMatrix = new ColorMatrix();

        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();

        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imgMatrix = new ColorMatrix();
        imgMatrix.postConcat(hueMatrix);
        imgMatrix.postConcat(saturationMatrix);
        imgMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imgMatrix));


        canvas.drawBitmap(bitmap,0,0,paint);//error bitmap



        return bitmap_cpoy;
    }
}
