package vcmsa.lubombuyu.imad5112_practicum_lubombuyu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.isBlank

private fun EditText.isBlank() {
    TODO("Not yet implemented")
}
// If you need to pass Song objects in Intents


class MainActivity : AppCompatActivity() {
    val songTitles = mutableListOf("Imagine", "Bohemian Rhapsody", "Shape of You", "Rolling in the Deep")
    val songArtists = mutableListOf("John Lennon", "Queen", "Ed Sheeran", "Adele")
    val songRatings = mutableListOf(4, 3, 5, 3) // Assuming Int for ratings
    val songComments = mutableListOf("Pop", "Rock and Roll", "Hip-Pop", "Pop")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Code starts here
        // Values to be used





        val Addplay = findViewById<ImageButton>(R.id.imgBAdd)
        val SearchPlay = findViewById<ImageButton>(R.id.imgBViewPlay)
        val ExitApp = findViewById<ImageButton>(R.id.imgBExit)




        // Sending user to the display playlist
        SearchPlay.setOnClickListener {
            val intent = Intent(this, ViewPlaylist::class.java)
            intent.putStringArrayListExtra("songTitles", ArrayList(songTitles))
            intent.putStringArrayListExtra("songArtists", ArrayList(songArtists))
            intent.putIntegerArrayListExtra("songRatings", ArrayList(songRatings))
            intent.putStringArrayListExtra("songComments", ArrayList(songComments))
            startActivity(intent)
        }

        //  Code to exit the App
        ExitApp.setOnClickListener {
            finishAffinity() // this ends the code
        }

        // Adding songs to arrays
        Addplay.setOnClickListener {
            val titleEditText = findViewById<EditText>(R.id.edtSongTitle)
            val artistEditText = findViewById<EditText>(R.id.edtArtistName)
            val ratingEditText = findViewById<EditText>(R.id.edtRatings) // Renamed for clarity
            val commentEditText = findViewById<EditText>(R.id.edtComments)

            val titleStr = titleEditText.text.toString()
            val artistStr = artistEditText.text.toString()
            val ratingStr = ratingEditText.text.toString()
            val commentStr = commentEditText.text.toString()

            // Validate input
            if (titleStr.isBlank()) { // Use isBlank() for String
                Toast.makeText(this, "Song title cannot be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Exit Addplay's listener
            }
            if (artistStr.isBlank()) { // Use isBlank() for String
                Toast.makeText(this, "Artist name cannot be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Rating validation
            if (ratingStr.isBlank()) {
                Toast.makeText(this, "Rating cannot be empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val rating = ratingStr.toIntOrNull()
            if (rating == null) {
                Toast.makeText(this, "Rating must be a valid number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (rating !in 1..5) {
                Toast.makeText(this, "Rating must be between 1 and 5 (inclusive).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            // If all validations pass, then add to lists:
            songTitles.add(titleStr)
            songArtists.add(artistStr)
            songRatings.add(rating) // Add the validated Int
            songComments.add(commentStr) // Add the comment string

            Toast.makeText(this, "\"$titleStr\" added successfully!", Toast.LENGTH_SHORT).show()

            // Optionally, clear the EditText fields after successful addition
            titleEditText.text.clear()
            artistEditText.text.clear()
            ratingEditText.text.clear()
            commentEditText.text.clear()
        }

            }
        }





