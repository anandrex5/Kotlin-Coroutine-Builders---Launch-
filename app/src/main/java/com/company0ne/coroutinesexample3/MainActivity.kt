package com.company0ne.coroutinesexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }
    private suspend fun printFollowers(){
    var fbFollowers = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }
        job.join()
        Log.d("TAG",fbFollowers.toString())
    }
   private suspend fun getFbFollowers():Int {
       delay(1000)
       return 54
   }
}
