package com.example.firestore

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_signup(view: View) {
        val email = tv_email.text.toString().trim { it <= ' ' }
        val name = tv_name.text.toString().trim { it <= ' ' }
        val note = tv_note.text.toString().trim { it <= ' ' }
        saveFirestore(name, email, note)
        getdata()
    }

    fun saveFirestore(name:String,email:String,note:String){
        val db= FirebaseFirestore.getInstance()
        val user1=db.collection("user1")
        val person = Person(name,email)
        val finalnote= Note(note)
        user1.document("userinfo")
            .set(person)
        user1.document("note")
            .set(finalnote)

    }
    fun getdata(){
        val db= FirebaseFirestore.getInstance()
        val doc= db.collection("user1").document("note")
        doc.get().addOnSuccessListener { document ->
            if(document!=null)
            {
                val disp= findViewById<TextView>(R.id.display)
                disp.setText("${document.data}")
            }

        }
            .addOnFailureListener {
                Toast.makeText(this,"could not get note",Toast.LENGTH_SHORT).show()
            }
    }
}






