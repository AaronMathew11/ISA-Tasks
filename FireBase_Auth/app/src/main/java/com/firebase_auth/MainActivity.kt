package com.firebase_auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userid = intent.getStringExtra("user_id")
        val emailid = intent.getStringExtra("email_id")

        displayemailid.text=" Email ID : $emailid"
        displayuserid.text= " User ID : $userid"

        btn_logout.setOnClickListener{

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}