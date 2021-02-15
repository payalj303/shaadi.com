package com.shaadi.ui.base;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
public class BaseBindingAdapter {

    @Inject
    public BaseBindingAdapter() {

    }

    @BindingAdapter({"url"})
    public static void setImageIcon(AppCompatImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().override(120, 120))
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageView);

    }


}
