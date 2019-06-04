package com.example.kotlinfirebaselogin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlinfirebaselogin.ui.login.PartnerLogin
import kotlinx.android.synthetic.main.activity_choose_user.*

class ChooseUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_user)
        var UserBtn = findViewById(R.id.userbtn) as Button
        var Partnerbtn = findViewById(R.id.partnerbtn) as Button
        UserBtn.setOnClickListener {
            var userintent = Intent(this,UserLogin::class.java)
            startActivity(userintent)
        }
        Partnerbtn.setOnClickListener {
            var partnerIntent = Intent(this,PartnerLogin::class.java)
            startActivity((partnerIntent))
        }

    }
}
