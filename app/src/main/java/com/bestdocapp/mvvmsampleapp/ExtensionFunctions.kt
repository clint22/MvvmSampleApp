package com.bestdocapp.mvvmsampleapp
import android.widget.Toast

/*https://www.youtube.com/watch?v=-ejajxJIhZk
Watch this video to know more about Extension functions in Kotlin */
fun String.showToast() = Toast.makeText(
    MyApplication.instance.applicationContext,
    this, Toast.LENGTH_SHORT
).show()

fun validate(input : String) {


}