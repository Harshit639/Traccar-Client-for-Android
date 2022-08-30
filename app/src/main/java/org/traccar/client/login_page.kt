package org.traccar.client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.supportActionBar!!.hide()

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val submit = findViewById<Button>(R.id.logins)

        fun submit(){
            val user= username.text
            val pass= password.text

            if(user.toString()!="" && pass.toString()!="") {

                Log.d("username", user.toString())
                Log.d("password", pass.toString())

                Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Enter username/password",Toast.LENGTH_SHORT).show()
            }

        }

        submit.setOnClickListener {
            submit()
        }

        password.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                submit()
                return@OnKeyListener true
            }
            false
        })


    }

}