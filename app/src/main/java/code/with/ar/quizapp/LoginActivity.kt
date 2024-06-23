//package code.with.ar.quizapp

//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import code.with.ar.quizapp.databinding.ActivityLoginBinding
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//
//class LoginActivity : AppCompatActivity() {
//    private lateinit var binding:ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding= ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportActionBar?.hide()
//        binding.button.setOnClickListener{
//            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
//                binding.password.editText?.text.toString()).addOnCompleteListener{
//                    if(it.isSuccessful)
//                    {
//                        Toast.makeText(this, "User Created!!!" , Toast.LENGTH_LONG).show()
//                    }
//                else{
//                    Toast.makeText(this , "User Failed !!!" , Toast.LENGTH_LONG).show()
//                    }
//
//            }
//        }
//
//    }
//}



/*package code.with.ar.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import code.with.ar.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.button.setOnClickListener {
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()

            // Check if email and password are not empty
            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "User created successfully!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}

*/



package code.with.ar.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import code.with.ar.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.button.setOnClickListener {
            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()

            // Check if email and password are not empty
            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "User created successfully!", Toast.LENGTH_LONG).show()

                    // Navigate to the QuestionsActivity (replace QuestionsActivity::class.java with your actual activity class)
                    val intent = Intent(this, QuizActivity::class.java)
                    startActivity(intent)

                    // Finish the current activity to prevent the user from coming back to the registration screen
                    finish()
                } else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}



