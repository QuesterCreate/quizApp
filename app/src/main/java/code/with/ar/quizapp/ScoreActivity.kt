package code.with.ar.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import code.with.ar.quizapp.databinding.ActivityScore2Binding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding:ActivityScore2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScore2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.score.setText("${intent.getIntExtra("SCORE" , 0)}")
    }
}