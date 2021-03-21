package ruzanna.game.androidhomework2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class LoginForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_form)

        val login = findViewById<Button>(R.id.login)
        val eMail = findViewById<EditText>(R.id.e_mail)
        val password = findViewById<EditText>(R.id.password)

        login.setOnClickListener(View.OnClickListener {
            val eMailText = eMail.getText().toString()
            val passwordText = password.getText().toString()
            if(isValidEmail(eMailText) && isValidPassword(passwordText)){
                Toast.makeText(applicationContext, "E-mail: $eMailText and Password are valid.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "E-mail: $eMailText or Password is invalid.", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun isValidEmail(email: String): Boolean {
        val valid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return if (valid)
            true
        else
            valid
    }
    fun isValidPassword(password:String): Boolean {

        if (password.length < 8) {
            return false
        }

        var exp = ".*[0-9].*"
        var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(password)
        if (!matcher.matches()) {
            return false
        }

        exp = ".*[A-Z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(password)
        if (!matcher.matches()) {
            return false
        }

        exp = ".*[a-z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(password)
        if (!matcher.matches()) {
            return false
        }

        exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(password)
        if (!matcher.matches()) {
            return false
        }

        return true
    }


}