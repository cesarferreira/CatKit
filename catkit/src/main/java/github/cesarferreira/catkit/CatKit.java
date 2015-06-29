package github.cesarferreira.catkit;


import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class CatKit {
    private Context mContext;
    private static CatKit mCatKit;
    private int mWidth;
    private int mHeight;

    public static CatKit with(Context context) {
        mCatKit = new CatKit(context);
        return mCatKit;
    }

    private CatKit(Context context) {
        mContext = context;
    }

    public CatKit px(int width, int height) {
        mWidth = pxToDp(width);
        mHeight = pxToDp(height);
        return mCatKit;
    }


    public CatKit dp(int width, int height) {
        mWidth = dpToPx(width);
        mHeight = dpToPx(height);
        return mCatKit;
    }

    public void into(ImageView imageView) {

        // clean the view
        imageView.setImageBitmap(null);
        Picasso.with(mContext).cancelRequest(imageView);

        // set the view
        Picasso.with(mContext)
                .load(getUrl())
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .into(imageView);
    }

    private String getUrl() {
        return "http://lorempixel.com/" + mWidth + "/" + mHeight + "/cats";
    }


    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
