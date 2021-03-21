package ruzanna.game.androidhomework2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detailsForm = findViewById<Button>(R.id.detailsForm)

        detailsForm.setOnClickListener{
            val intent = Intent(this, DetailsForm::class.java)
            startActivity(intent)
        }

        val loginForm = findViewById<Button>(R.id.loginForm)

        loginForm.setOnClickListener{
            val intent = Intent(this, LoginForm::class.java)
            startActivity(intent)
        }
    }

}
