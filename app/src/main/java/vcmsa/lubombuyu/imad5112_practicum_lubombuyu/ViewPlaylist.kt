package vcmsa.lubombuyu.imad5112_practicum_lubombuyu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.TableLayout // Make sure this is imported
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewPlaylist : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_playlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- View References ---
        val mainMenu = findViewById<ImageButton>(R.id.imgBMainMenu) // Assuming this is from your XML
        val displayPlayButton = findViewById<ImageButton>(R.id.imgBDisplayPlay) // Assuming this is your button
        val tableLayout = findViewById<TableLayout>(R.id.tbLay1) // Make sure this ID matches your XML

        // --- Get Data from Intent ---
        // It's better to use ArrayList for more flexibility if they were originally ArrayLists
        val songTitles = intent.getStringArrayListExtra("songTitles")
        val songArtists = intent.getStringArrayListExtra("songArtists")
        val songRatings = intent.getIntegerArrayListExtra("songRatings")
        val songComments = intent.getStringArrayListExtra("songComments")

        // --- Navigation ---
        mainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Finish this activity
        }

        // --- Logic for the Display Button (if you still want it to do something, like refresh) ---
        displayPlayButton.setOnClickListener {
            Toast.makeText(this, "Playlist is already displayed.", Toast.LENGTH_SHORT).show()
        }

        // --- Populate Table on Activity Creation ---
        populateTable(tableLayout, songTitles, songArtists, songRatings, songComments)
    }

     fun populateTable(
        tableLayout: TableLayout,
        titles: ArrayList<String>?,
        artists: ArrayList<String>?,
        ratings: ArrayList<Int>?,
        comments: ArrayList<String>?
    ) {
        tableLayout.removeAllViews() // Clear previous data if any (important if this function is called multiple times)

        // Check if data is present and lists have the same size (basic check)
        if (titles.isNullOrEmpty()) {
            val noDataMessage = TextView(this).apply {
                text = "No songs in the playlist."
                textSize = 18f // Make it a bit bigger
                gravity = Gravity.CENTER
                setPadding(16, 32, 16, 32) // Add some padding
            }
            val row = TableRow(this).apply {
                addView(noDataMessage)
                // If you want the message to span all columns (assuming 4 columns)
                (noDataMessage.layoutParams as? TableRow.LayoutParams)?.span = 4
            }
            tableLayout.addView(row)
            return
        }


        val minSize = listOfNotNull(titles?.size, artists?.size, ratings?.size, comments?.size).minOrNull() ?: 0

        for (i in 0 until minSize) {
            val row = TableRow(this)


            val titleTv = TextView(this)
            val artistTv = TextView(this)
            val ratingTv = TextView(this)
            val commentTv = TextView(this)


            val cellParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
            cellParams.weight = 1f // Distribute width equally if desired (for fixed number of columns)
            cellParams.setMargins(8, 8, 8, 8) // Add some margins

            titleTv.layoutParams = cellParams
            artistTv.layoutParams = cellParams
            ratingTv.layoutParams = cellParams
            commentTv.layoutParams = cellParams
            ratingTv.gravity = Gravity.CENTER // Center rating text

            // Set the text for each TextView
            titleTv.text = titles?.get(i) ?: "N/A"
            artistTv.text = artists?.get(i) ?: "N/A"
            ratingTv.text = ratings?.get(i)?.toString() ?: "N/A"
            commentTv.text = comments?.get(i) ?: "N/A"

            // Add TextViews to the TableRow
            row.addView(titleTv)
            row.addView(artistTv)
            row.addView(ratingTv)
            row.addView(commentTv)

            // Add the TableRow to the TableLayout
            tableLayout.addView(row)
        }
    }
}