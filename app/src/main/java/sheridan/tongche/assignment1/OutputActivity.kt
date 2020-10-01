package sheridan.tongche.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import sheridan.tongche.assignment1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {


    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userChoice = intent.getStringExtra("User_Choice")
        val result = play(userChoice.toString())
        binding.yourChoice.text = "Your Choice: $userChoice"
        binding.gameResult.text = result

        binding.playAgain.setOnClickListener { playAgain() }

    }

    private fun playAgain() {
        val intent = Intent(this, InputActivity::class.java)
        startActivity(intent)
    }

    fun play(userChoice: String): String {

        val value = (0..2).random()
        val valueList = listOf("Paper", "Rock", "Scissors")
        val answer = valueList[value]
        binding.computerChoice.text = "Computer Choice: $answer"
        when (answer) {
            "Paper" -> when (userChoice) {
                "Paper" -> return "Draw"
                "Rock" -> return "Lose"
                "Scissors" -> return "Win"
            }
            "Rock" -> when (userChoice) {
                "Paper" -> return "Win"
                "Rock" -> return "Draw"
                "Scissors" -> return "Lose"
            }
            "Scissors" -> when (userChoice) {
                "Paper" -> return "Lose"
                "Rock" -> return "Win"
                "Scissors" -> return "Draw"
            }
        }
        return "Error"
    }
}