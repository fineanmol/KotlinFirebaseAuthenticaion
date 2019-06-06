package com.example.kotlinfirebaselogin

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.notification.ConditionProviderService
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.Auth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*



class MainActivity : AppCompatActivity() {

    lateinit var providers: List<AuthUI.IdpConfig>
    val MY_REQUEST_CODE:Int=7117 //Any Number you want


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        providers= Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(), //Email Login
            AuthUI.IdpConfig.FacebookBuilder().build(), //Facebook Login
            AuthUI.IdpConfig.GoogleBuilder().build(), //Google Login
            AuthUI.IdpConfig.AnonymousBuilder().build(), //Anonymous Login
            AuthUI.IdpConfig.PhoneBuilder().build() //Phone Login
        )
        showSignInOptions()
        //EVent
        btn_sign_out.setOnClickListener {
            //signout
            AuthUI.getInstance().signOut(this@MainActivity)
                .addOnCompleteListener{
                    btn_sign_out.isEnabled=false
                    showSignInOptions()
                }
                .addOnFailureListener{
                    e->Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_SHORT).show()
                }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==MY_REQUEST_CODE){
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode== Activity.RESULT_OK)
            {
                val user= FirebaseAuth.getInstance().currentUser //get current user
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()

                btn_sign_out.isEnabled = true
            }
            else{
                Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()

            }
        }
    }


    private fun showSignInOptions() {
    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .setTheme(R.style.MyThemes)
        .build(),MY_REQUEST_CODE)
    }
}
