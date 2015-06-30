package github.cesarferreira.catkit.example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;

import github.cesarferreira.catkit.CatKit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        ImageView targetImageView = (ImageView) findViewById(R.id.targetImageView);


        // Simple way...
        // CatKit.with(context).dp(200, 200).into(targetImageView);

        // More complete way
        CatKit.with(context)
                .dp(300, 400)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .into(targetImageView);
    }


}
