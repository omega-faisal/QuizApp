package eu.tutorials.quizapp

data class questions(
    val id:Int,
    val question:String,
    val image:Int,

    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,

    val CorrectAnswer:Int
)

