# CatKit
<p align="center">

Android <strong>kit</strong> for <strong>cat placeholders</strong>
</p>
<p align="center">
<img src="https://raw.github.com/cesarferreira/catkit/master/extras/images/catkit_logo_trimmed.png?raw=true" width="100%" />
</p>

## Usage

With Density-independent Pixels:
```java
CatKit.with(context).dp(200, 200).into(targetImageView);
```


With Pixels:
```java
CatKit.with(context).px(500, 300).into(targetImageView);
```

Memory Policy:
```java
CatKit.with(context).dp(200, 200).memoryPolicy(MemoryPolicy.NO_CACHE).into(targetImageView);
```
## Usage with Picasso Downloader

If you already use Picasso for image loading you can override the downloader to provide cat images throughout your existing app
```java
Picasso picasso = new Picasso.Builder(this).downloader(new CatKitDownloader(this)).build();
picasso.load("http://dummyurl.com") //this url will be ignored by CatKitDownloader
        .into(targetImageView);
```

## Install


Add the dependency to your `build.gradle`
```groovy
dependencies {
  compile 'com.cesarferreira.catkit:catkit:0.3.0'
}
```



## Contributing

1. Fork it ( https://github.com/cesarferreira/catkit/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
