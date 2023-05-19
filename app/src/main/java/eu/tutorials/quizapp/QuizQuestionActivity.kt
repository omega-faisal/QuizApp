package eu.tutorials.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener{
    private var mQuestionList:ArrayList<questions>?=null
    private var mUSERNAME:String?=null
    private var mCorrectAns:Int=0
    private var mCurrentPos:Int=1
    private var mSelectedOpPos:Int=0
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var progressbar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvOption1:TextView?=null
    private var tvOption2:TextView?=null
    private var tvOption3:TextView?=null
    private var tvOption4:TextView?=null
    private var subButton:Button?=null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUSERNAME=intent.getStringExtra(Constants.USER_NAME)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        progressbar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvOption1=findViewById(R.id.option1)
        tvOption2=findViewById(R.id.option2)
        tvOption3=findViewById(R.id.option3)
        tvOption4=findViewById(R.id.option4)
        subButton=findViewById(R.id.submitButton)
        mQuestionList = Constants.getQuestions()
        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        subButton?.setOnClickListener(this)
        SetQuestion()
    }



    private fun SetQuestion() {
        val question: questions = mQuestionList!![mCurrentPos- 1]
        defaultOptionsView()
        progressbar?.progress = mCurrentPos
        tvProgress?.text = "$mCurrentPos/${progressbar?.max}"
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour
    }
    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.option1 ->{
                tvOption1?.let {
                    SelectedOptionView(it,1)
                }
            }
            R.id.option2 ->{
                tvOption2?.let {
                    SelectedOptionView(it,2)
                }
            }
            R.id.option3 ->{
                tvOption3?.let {
                    SelectedOptionView(it,3)
                }
            }
            R.id.option4 ->{
                tvOption4?.let {
                    SelectedOptionView(it,4)
                }
            }
            R.id.submitButton ->{
                if(mSelectedOpPos==0)
                {
                    mCurrentPos++
                    if(mCurrentPos<=mQuestionList!!.size) {
                        SetQuestion()
                    }
                        else
                        {
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANS,mCorrectAns)
                            intent.putExtra(Constants.GIVEN_QUES,mQuestionList!!.size)
                            intent.putExtra(Constants.USER_NAME,mUSERNAME)
                            startActivity(intent)
                            finish()
                        }
                }

                else
                {
                    val ques= mQuestionList!![mCurrentPos-1]
                    if(ques.CorrectAnswer+1!=mSelectedOpPos)
                    {
                        answerView(mSelectedOpPos,R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAns++
                    }
                    answerView(ques.CorrectAnswer+1,R.drawable.correct_option_bg)
                    if(mCurrentPos== mQuestionList!!.size)
                    {
                        subButton?.text="FINISH"
                    }else {
                        subButton?.text="NEXT QUESTION"
                    }
                    mSelectedOpPos=0
                }

            }
        }

    }

    private fun SelectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
           defaultOptionsView()
           subButton?.text="SUBMIT"
           tv.setTextColor(Color.parseColor("#363A43"))
          tv.setTypeface(tv.typeface,Typeface.BOLD_ITALIC)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
        mSelectedOpPos=selectedOptionNum
    }
    private fun defaultOptionsView()
    {
        val options=ArrayList<TextView>()
        tvOption1?.let {
            options.add(0,it)
        }
        tvOption2?.let {
            options.add(1,it)
        }
        tvOption3?.let {
            options.add(2,it)
        }
        tvOption4?.let {
            options.add(3,it)
        }
        for(option in options)
        {
            option.setTextColor(Color.parseColor("#8d99ae"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this
                ,R.drawable.default_option_border_bg)
        }

    }
    private fun answerView(answer:Int,drawableView:Int)
    {
        when(answer)
        {
            1->
            {
                tvOption1?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }2->
            {
                tvOption2?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }3->
            {
                tvOption3?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }4->
            {
                tvOption4?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }


}