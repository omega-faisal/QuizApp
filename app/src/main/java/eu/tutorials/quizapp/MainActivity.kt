package eu.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart:Button=findViewById(R.id.btn_start)
        val etText:EditText=findViewById(R.id.et_text)

        btnStart.setOnClickListener {
            if(etText.text.isEmpty())
            {
                Toast.makeText(this, "please enter your name", Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etText.text.toString())
                startActivity(intent)
                finish() // this will finish the main activity
            }
        }
    }
}