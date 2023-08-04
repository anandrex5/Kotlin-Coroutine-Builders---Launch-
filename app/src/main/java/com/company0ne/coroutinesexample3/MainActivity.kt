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
    private suspend fun printFollowers() {
        
        CoroutineScope(Dispatchers.IO).launch {
            var fb = async {  getFbFollowers()}
            var insta = async {  getInstaFollowers()}
            Log.d("TAG", "Fb - ${fb.await()}, Insta - ${insta.await()}" )
        }
    }
   private suspend fun getFbFollowers():Int{
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers():Int{
        delay(1000)
        return 113
    }
}