package com.bestdocapp.mvvmsampleapp

import android.widget.Toast

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