package github.cesarferreira.catkit.example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.cesarferreira.catkit.CatKit;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.targetImageView)
    ImageView targetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Context context = getApplicationContext();

        CatKit.with(context).dp(200, 200).into(targetImageView);
    }


}
