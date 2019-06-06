/*
package com.example.kotlinfirebaselogin

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.firebase.ui.auth.data.model.User
import java.sql.RowId

class UserAdapter(val mCtx:Context,val layoutResId: Int,val userList:List<User>)
    :ArrayAdapter<User>(mCtx,layoutResId,userList)

{
    @SuppressLint("RestrictedApi")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(layoutResId,null)

        val textViewName= view.findViewById<TextView>(R.id.textViewName)
        val user = userList[position]
        textViewName.text = user.name
        return  view;

    }
}*/
