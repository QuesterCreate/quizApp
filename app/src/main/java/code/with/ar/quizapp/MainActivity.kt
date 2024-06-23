package code.with.ar.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        supportActionBar?.hide()
//        Handler(Looper.getMainLooper()).postDelayed(3000){
//
//
//            if (Firebase.auth.currentUser!=null) {
//                val intent = Intent(this, QuizActivity::class.java)
//
//                startActivity(intent)
//            }
//            else{
//                val intent=Intent(this,LoginActivity::class.java)
//                intent.putExtra("MODE" , "SIGNUP")
//                startActivity(intent)
//
//            }
//        }
//    }
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed(3000) {
            // Check if the user is already signed in
            val currentUser = Firebase.auth.currentUser

            if (currentUser != null) {
                // User is signed in, sign them out before proceeding to login/signup
                Firebase.auth.signOut()
            }

            //change1

            // Launch LoginActivity with signup mode
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("MODE", "SIGNUP")
            startActivity(intent)

            // Finish MainActivity to prevent going back to it
            finish()
        }
    }
}

