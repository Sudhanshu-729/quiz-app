package hey.there.sdquizapp

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getquestions():ArrayList<Question>{
        val questionList= ArrayList<Question>()
        //qOne
        val qOne=Question(
            id = 1,"Which of the following is not a prime number ?"
            ,"2","19","37","39",
            4
        )
        questionList.add(qOne)

        //q2
        val q2=Question(
            id = 2,"Who is the World's Fastest Land Animal ?"
            ,"Wildebeest","Leopard","Cheetah"
            ,"Pronghorn", 3
        )
        questionList.add(q2)

        //q3
        val q3=Question(
            id = 3,"Who is the first Indian to get Nobel Prize ?"
            ,"Amartya Sen","Rabindranath Tagore",
            "Subrahmanyan Chandrasekhar","Har Gobind Khorana",
            2
        )
        questionList.add(q3)

        //q4
        val q4=Question(
            id = 4,"Which of the following is not a continent ?"
            ,"Australia","Canada","Asia","Africa",
            2
        )
        questionList.add(q4)

        //q5
        val q5=Question(
            id = 5,"Who was the last Viceroy of India? ?"
            ,"Lord Irwin","Lord Willingdon","Lord Curzon",
            "Lord Mountbatten", 4
        )
        questionList.add(q5)

        //q6
        val q6=Question(
            id = 6,"Who was the founder of Indian Space Research Organisation (ISRO)?"
            ,"Vikram Sarabhai","Homi J. Bhabha",
            "C. V. Raman","Jagadish Chandra Bose",
            1
        )
        questionList.add(q6)

        //q7
        val q7=Question(
            id = 7,"Who built the Konark Sun Temple? ?"
            ,"Ajayapala","Arjunavarman II","King Narasimhadeva I"
            ,"Athirajendra Chola",
            3
        )
        questionList.add(q7)

        //q8
        val q8=Question(
            id = 8,"What is the atomic number of Oxygen ?"
            ,"7","8","9","16",
            2
        )
        questionList.add(q8)

        //q9
        val q9=Question(
            id = 9,"Choose the correct synonym of 'Genesis'?"
            ,"Relevant","Beginning","Movement","Style",
            2
        )
        questionList.add(q9)

        //q10
        val q10=Question(
            id = 10,"Which is the largest planet in our solar system? ?"
            ,"Jupiter","Neptune","Venus","Earth",
            1
        )
        questionList.add(q10)

        return questionList
    }
}