package github.cesarferreira.catkit;


import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class CatKit {
    private Context mContext;
    private static CatKit mCatKit;
    private int mWidth;
    private int mHeight;
    private MemoryPolicy mMemoryPolicy = null;

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

        if (imageView == null) {
            Log.e("CatKit", "target image view is NULL");
        }

        // clean the view
        assert imageView != null;
        imageView.setImageBitmap(null);
        Picasso.with(mContext).cancelRequest(imageView);

        // set the image view
        RequestCreator request = Picasso.with(mContext).load(getUrl());

        // Show solid red after failing 3 times
        request.error(R.drawable.solid_red);

        if (mMemoryPolicy != null) {
            request.memoryPolicy(mMemoryPolicy);
        }

        request.into(imageView);
    }

    private String getUrl() {
        return Util.getUrl(mHeight, mWidth);
    }


    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public CatKit memoryPolicy(MemoryPolicy memoryPolicy) {
        mMemoryPolicy = memoryPolicy;
        return mCatKit;
    }
}
