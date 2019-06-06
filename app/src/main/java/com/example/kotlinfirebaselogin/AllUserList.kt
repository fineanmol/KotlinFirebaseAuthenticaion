package com.example.kotlinfirebaselogin


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter

import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.*

class AllUserList : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    val TAG="DataRecieved"
    lateinit var employeeList: MutableList<Data>
    lateinit var listview : ListView
    var array= arrayListOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_user_list)

        var userlists= findViewById<ListView>(R.id.users_list_view)
        var textview = findViewById<TextView>(R.id.userdetails)
         array.remove("")
        /*Database Retreival Code*/
        database = FirebaseDatabase.getInstance().getReference("Users")
        val postListener = object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                // Get Post object and use the values to update the UI
                // TestAdd Values
           /*     if (p0!!.exists()) {
                    employeeList.clear()
                    for (e in p0.children) {
                        val employee = e.getValue(Data::class.java)
                        employeeList.add(employee!!)
                    }
                    val adapter = customAdapter(this@AllUserList, R.layout.users, employeeList)
                    listview.adapter = adapter
                }
*/
                for (d in p0.children){
                    var Id= d.key
                    var Values= d.value.toString().split(",")
                    var Mobile = (Values[0].split("=")).last()
                    var password = (Values[1].split("=")).last()
                    var Address = (Values[2].split("=")).last()
                   var emailidfromfirebase = Values[5].split("=")[1].split("}")[0]
                    var Name = (Values[3].split("=")).last()



                    Log.d(TAG, "Value is: $d")
                    array.add(Name + " key is" +" : "+ Id + " having "+emailidfromfirebase+ " email!!")
                }

                // ...
            }

            override fun onCancelled(p0: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", p0.toException())
                // ...
            }
        }
        database.addValueEventListener(postListener)
        /*Database Retrieval code ends*/





        var copylist = array
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1, array
        )

        userlists.setAdapter(adapter);



    }
}
