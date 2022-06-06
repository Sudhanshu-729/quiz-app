package hey.there.sdquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity(),View.OnClickListener {

    private var mCp=1
    private var myQl:ArrayList<Question>?=null
    private var mySop=0
    private var mUserN:String?=null
    private var mCAnswers:Int=0

    private var progressBar:ProgressBar?=null
    private var tvPbar:TextView?=null
    private var tvQuestion:TextView?=null
    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btnSubmit:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mUserN=intent.getStringExtra(Constants.USER_NAME)
        progressBar=findViewById(R.id.pBar)
        tvPbar=findViewById(R.id.tvPro)
        tvQuestion=findViewById(R.id.tvQue)
        tvOptionOne=findViewById(R.id.tvOptionOne)
        tvOptionTwo=findViewById(R.id.tvOptionTwo)
        tvOptionThree=findViewById(R.id.tvOptionThree)
        tvOptionFour=findViewById(R.id.tvOptionFour)
        btnSubmit=findViewById(R.id.btnSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        myQl=Constants.getquestions()
        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = myQl!![mCp - 1]
        progressBar?.progress = mCp
        tvPbar?.text = "$mCp/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCp==myQl!!.size){
            btnSubmit?.text="FINISH"
        }else btnSubmit?.text="SUBMIT"
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this, R.drawable.default_option_bg)

        }

    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionView()
        mySop=selectedOptionNum
        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this, R.drawable.selected_option_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, selectedOptionNum = 1)
                }
            }
            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, selectedOptionNum = 2)
                }
            }
            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, selectedOptionNum = 3)
                }
            }
            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, selectedOptionNum = 4)
                }
            }

            R.id.btnSubmit ->{
                if (mySop==0){
                    mCp++

                    when{
                        mCp<=myQl!!.size ->{
                            setQuestion()
                        }

                        else -> {
                            val intent=Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserN)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, myQl?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question=myQl?.get(mCp-1)
                    if (question!!.correctAnswer != mySop){
                        answerView(mySop, R.drawable.wrong_option_bg)
                    }else{
                        mCAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.right_option_bg)

                    if(mCp==myQl!!.size){
                        btnSubmit?.text ="FINISH"
                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mySop=0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView:Int){
        when (answer){
            1 -> {
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background=ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tvOptionThree?.background=ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tvOptionFour?.background=ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}