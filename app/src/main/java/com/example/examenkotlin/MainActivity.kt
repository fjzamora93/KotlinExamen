package com.example.examenkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{
        const val NAME_KEY = "NAME_KEY"
    }

    private var name:String = "";
    private var password:String = "";

    // Lateinit para todos los elementos visuales
    private lateinit var submitButton: Button;
    private lateinit var editTextUserName: EditText;
    private lateinit var editTextPassword: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents();
        initListeners();
        initUI();

    }

    private fun initComponents() {
        this.submitButton = findViewById<Button>(R.id.submitButton);
        this.editTextUserName = findViewById<EditText>(R.id.name);
        this.editTextPassword = findViewById<EditText>(R.id.password);
    }

    private fun initListeners() {
        this.submitButton.setOnClickListener {
            this.name = this.editTextUserName.text.toString();
            this.password = this.editTextPassword.text.toString();

            if (this.name.isEmpty() && this.password.isEmpty()){
                this.editTextUserName.error = "Usuario obligatorio";
                this.editTextPassword.error = "Contraseña obligatoria";
            } else {
                navigateToResult();
            }

        }
    }

    private fun initUI() {
        println("Nada de momento");
    }

    private fun navigateToResult(){
        val intent = Intent(this, ResultActivity::class.java);
        intent.putExtra("NAME_KEY", this.name);
        this.startActivity(intent);
    }


}