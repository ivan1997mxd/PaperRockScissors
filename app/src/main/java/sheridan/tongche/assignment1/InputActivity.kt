package sheridan.tongche.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import sheridan.tongche.assignment1.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    var userChoice: String = "Paper"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener { play() }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.paper ->
                    if (checked) {
                        userChoice = "Paper"
                    }
                R.id.rock ->
                    if (checked) {
                        userChoice = "Rock"
                    }
                R.id.scissors ->
                    if (checked) {
                        userChoice = "Scissors"
                    }
            }
        }
    }

    private fun play() {
        Toast.makeText(this, userChoice, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, OutputActivity::class.java)
        intent.putExtra("User_Choice", userChoice)
        startActivity(intent)
    }

}