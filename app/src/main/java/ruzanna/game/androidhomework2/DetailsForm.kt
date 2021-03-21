package ruzanna.game.androidhomework2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class DetailsForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_form)

        val spinner: Spinner = findViewById(R.id.spinner)

        val ad = ArrayAdapter.createFromResource(
            this,
            R.array.spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val detailsForm = findViewById<Button>(R.id.registration)

        val firstNameEditText = findViewById<EditText>(R.id.first_name)
        val lastNameEditText = findViewById<EditText>(R.id.last_name)
        val ageEditText = findViewById<EditText>(R.id.age)

        detailsForm.setOnClickListener(View.OnClickListener {
            val firstName = firstNameEditText.getText().toString()
            val lastName = lastNameEditText.getText().toString()
            val age = ageEditText.getText().toString()
            val gender = spinner.getSelectedItem().toString()

            Toast.makeText(applicationContext, "Name: $firstName $lastName, gender: $gender, age: $age.", Toast.LENGTH_LONG).show()
        })
    }
}
