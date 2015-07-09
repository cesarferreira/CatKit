package github.cesarferreira.catkit;

import android.content.Context;
import android.net.Uri;

import com.squareup.picasso.UrlConnectionDownloader;

import java.io.IOException;

/**
 * Custom {@link com.squareup.picasso.Downloader} to be used with {@link com.squareup.picasso.Picasso.Builder#downloader}
 */
public class CatKitDownloader extends UrlConnectionDownloader{

    public CatKitDownloader(Context context){
        super(context);
    }

    @Override
    public Response load(Uri uri, int networkPolicy) throws IOException {
        uri = Uri.parse(Util.getUrl(200,200));
        return super.load(uri, networkPolicy);
    }
}
