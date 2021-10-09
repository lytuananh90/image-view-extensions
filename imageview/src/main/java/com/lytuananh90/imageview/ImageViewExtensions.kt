package com.lytuananh90.imageview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation

/* Showing a photo from an url*/
@BindingAdapter(
    value = ["android:photoUrl", "android:placeholderResId", "android:errorResId", "android:isBlur"],
    requireAll = false
)
fun ImageView.loadPhotoUrl(
    photoUrl: String,
    placeholderResId: Int,
    errorResId: Int,
    isBlur: Boolean? = false
) {
    Picasso.get().load(photoUrl).let {
        it.placeholder(placeholderResId)
        if (isBlur == true) {
            it.transform(BlurTransformation(this.context))
        }
        it.error(errorResId)
        it.into(this)
    }
}

@BindingAdapter(value = ["imgResourceId"], requireAll = false)
fun ImageView.setImgResourceId(resId: Int?) {
    resId?.let {
        this.setImageResource(it)
    }
}