package com.example.examenkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenkotlin.MainActivity.Companion.NAME_KEY

class ResultActivity : AppCompatActivity() {

    private lateinit var userData: TextView;
    private lateinit var backButton: Button;
    private var name:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        this.name = intent.extras?.getString(NAME_KEY)?: "NO USER";
        initComponents();
        initListeners();
        initUI();

    }


    private fun initComponents() {
        this.userData = findViewById<TextView>(R.id.userData);
        this.backButton = findViewById<Button>(R.id.backButton);
    }

    private fun initUI() {
        this.userData.text = this.name;
    }

    private fun initListeners() {
        this.backButton.setOnClickListener {
           navigateBack();
        }
    }


    private fun navigateBack(){
        val intent = Intent(this, MainActivity::class.java);
        this.startActivity(intent);
    }

}