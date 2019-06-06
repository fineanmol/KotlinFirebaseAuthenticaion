package com.example.kotlinfirebaselogin


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.kotlinfirebaselogin.ui.login.PartnerLogin

class UserLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlinfirebaselogin.R.layout.activity_user_login)
        var linkSignup = findViewById(R.id.link_signup) as Button
        linkSignup.setOnClickListener {
            var Intent = Intent(this,SignupActivity::class.java)
            startActivity(Intent)
        }



    }
}
