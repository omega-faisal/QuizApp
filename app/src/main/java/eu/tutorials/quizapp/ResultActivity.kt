package eu.tutorials.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name:TextView=findViewById(R.id.tv_name)
        val score:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)
        name.text=intent.getStringExtra(Constants.USER_NAME)
        val totalQues=intent.getIntExtra(Constants.GIVEN_QUES,0)
        val correctAns=intent.getIntExtra(Constants.CORRECT_ANS,0)

        score.text="Your Score is $correctAns out of $totalQues"

        btnFinish.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}