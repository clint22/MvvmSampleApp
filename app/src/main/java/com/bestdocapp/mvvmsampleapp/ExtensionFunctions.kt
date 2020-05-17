package com.bestdocapp.mvvmsampleapp

import android.content.Context
import android.view.View
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

/*https://www.youtube.com/watch?v=-ejajxJIhZk
  Watch this video to know more about Extension functions in Kotlin */
fun String.showToast() = Toast.makeText(
    MyApplication.instance.applicationContext,
    this, Toast.LENGTH_SHORT
).show()


/* https://www.youtube.com/watch?v=tNsW-Vl0mX4
   Watch this video to know more about local functions in Kotlin */
fun validate(input: String?): Boolean {
    return input?.isNotEmpty() ?: false
}

fun LottieAnimationView.startLottieAnimation() {
    this.visibility = View.VISIBLE
    this.playAnimation()
    this.repeatMode
}


fun LottieAnimationView.stopLottieAnimation() {
    this.visibility = View.GONE
    this.cancelAnimation()
}

fun String.setStringSharedPreference(sharedPrefKey: String) {

    val preference = MyApplication.instance.applicationContext.getSharedPreferences(
        MyApplication.instance.getString(R.string.app_name), Context.MODE_PRIVATE
    )
    val editor = preference.edit()
    editor.putString(sharedPrefKey, this)
    editor.apply()

}


fun getStringSharedPreference(sharedPrefKey: String): String? {
    val preference = MyApplication.instance.applicationContext.getSharedPreferences(
        MyApplication.instance.getString(R.string.app_name), Context.MODE_PRIVATE
    )
    return preference.getString(sharedPrefKey, "")
}