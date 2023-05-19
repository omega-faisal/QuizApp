package eu.tutorials.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val GIVEN_QUES:String="0"
    const val CORRECT_ANS:String="0"
    fun getQuestions():ArrayList<questions>
    {
        val questionlist=ArrayList<questions>()

        val q1=questions(
            1,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_russia,
            "India",
            "France",
            "Russia",
            "Denmark",
            2

        )
        questionlist.add(q1)
        val q2=questions(
            2,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_turkey,
            "Turkey",
            "Chile",
            "Pakistan",
            "Egypt",
            0
        )
        questionlist.add(q2)
        val q3=questions(
            3,"Which Country Does This Flag Belong To"
        , R.drawable.flag_australia,
            "England",
            "U.S.A",
            "Australia",
            "Netherlands",
            2
        )
        questionlist.add(q3)
        val q4=questions(
            4,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_germany,
            "Belgium",
            "Germany",
            "France",
            "Prague",
            1
        )
        questionlist.add(q4)
        val q5=questions(
            5,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_india,
            "South korea",
            "Ireland",
            "Niger",
            "India",
            3
        )
        questionlist.add(q5)
        val q6=questions(
            6,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_southkorea,
            "Japan",
            "Portugal",
            "Argentina",
            "South korea",
            3
        )
        questionlist.add(q6)
        val q7=questions(
            7,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_nepal,
            "Nepal",
            "Bhutan",
            "Malaysia",
            "Myanmar",
            0
        )
        questionlist.add(q7)
        val q8=questions(
            8,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_usa,
            "Australia",
            "U.K",
            "U.S.A",
            "New Zealand",
            2
        )
        questionlist.add(q8)
        val q9=questions(
            9,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_switzerland,
            "Switzerland",
            "Denmark",
            "Norway",
            "Greenland",
            2
        )
        questionlist.add(q9)
        val q10=questions(
            10,"Which Country Does This Flag Belong To"
        ,R.drawable.flag_uzbeskistan,
            "Kazakhstan",
            "Mongolia",
            "Uzbekistan",
            "Turkmenistan",
            2
        )
        questionlist.add(q10)
        return questionlist
    }
}