package com.firebase_auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.tv_email

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_registernow.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }
        btn_login.setOnClickListener{
            when{
                TextUtils.isEmpty(tv_email.text.toString().trim{ it <= ' '}) ->{
                    Toast.makeText(this,"Please Enter your Email", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(tv_password.text.toString().trim{ it <= ' '})->{
                    Toast.makeText(this,"Please enter your Password", Toast.LENGTH_SHORT).show()
                }
                else ->{
                    val email= tv_email.text.toString().trim{ it <= ' '}
                    val pass= tv_password.text.toString().trim{ it <= ' '}

                    // here is the important part..... create an instance for Firebase
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                // if registration is successful
                                if(task.isSuccessful){

                                    // Firebase registered user
                                    val firebaseuser : FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this,"Login Succesfull", Toast.LENGTH_SHORT).show()


                                    val intent = Intent(this,MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",firebaseuser.uid)
                                    intent.putExtra("email_id",email)
                                    startActivity(intent)
                                    finish()
                                }
                                else{
                                    //if the registration is not successful
                                    Toast.makeText(this,task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT).show()
                                }

                            }
                        )
                }
            }
        }
    }


    }

