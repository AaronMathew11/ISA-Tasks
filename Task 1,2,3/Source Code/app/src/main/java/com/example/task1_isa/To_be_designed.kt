package com.example.task1_isa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class To_be_designed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_be_designed)
    val ibtn=findViewById<ImageButton>(R.id.ibtn)
    ibtn.setOnClickListener {
        val intent =Intent(this,Profile1::class.java)
        startActivity(intent)
    }
    }
}