package com.example.kotlinfirebaselogin


import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.firebase.ui.auth.data.model.User
import android.widget.ListView
import com.google.firebase.database.*


class SignupActivity : AppCompatActivity() {


    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var number: EditText
    lateinit var password: EditText
    lateinit var address: EditText
//  lateinit var  listView:ListView


    lateinit var ref:DatabaseReference
//  lateinit var userList:MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
//      userList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Users")
        var LoginBtn = findViewById<Button>(R.id.link_login)
        LoginBtn.setOnClickListener {
            var Intent = Intent(this, UserLogin::class.java)
            startActivity(Intent)
        }
        name = findViewById(R.id.input_name)
        email = findViewById(R.id.input_email)
        address = findViewById(R.id.input_address)
        number = findViewById(R.id.input_mobile)
        password = findViewById(R.id.input_password)
//        listView = findViewById(R.id.ListView)

         var createAccount = findViewById(R.id.btn_signup) as Button


        createAccount.setOnClickListener {
           addUser()
        }
        /*ref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
            if(p0!!.exists()){
                userList.clear()
                for(h in p0.children){
                    val user = h.getValue(User::class.java)
                    userList.add(user!!)
                }
                val adapter=UserAdapter(applicationContext,R.layout.activity_user_login,userList) //R.layout.users
                listView.adapter=adapter
            }
            }

        });*/
    }

private fun addUser(){
    val Personname= name.text.toString().trim()

    if(Personname.isEmpty()){
        name.error="Please Enter a Name"
        return
    }


    ref = FirebaseDatabase.getInstance().getReference("Users")
    val userId= (ref.push().key).toString()
    val addUser = User(userId,name.text.toString(),email.text.toString().trim(),number.text.toString(),address.text.toString(),password.text.toString())

    ref.child("Users").child(userId).setValue(addUser)
    Toast.makeText(this,"Registration Successful",Toast.LENGTH_LONG).show()
    val intent = Intent(this,UserLogin::class.java)
    startActivity(intent)


}


}


