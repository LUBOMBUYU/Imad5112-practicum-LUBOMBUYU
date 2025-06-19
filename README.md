# 🎵 My Music Playlist App 🎶

My Music Playlist App is a mobile application that allows users to create, manage, and view their personal music playlists. Users can add songs with details like artist name, ratings, and comments, and then view their compiled playlist.

🔗 **Links**
*   **GitHub Repository:** [[YOUR_MUSIC_APP_REPO_LINK_HERE]](https://github.com/VCWVL/imad5112-practicum-LUBOMBUYU.git)  <!-- Make sure to replace this with the actual link -->
*  

---

📌 **Purpose of the App**

This application provides a simple and effective way for users to keep track of songs they like, categorize them with personal ratings and comments, and view their collection in an organized manner.

**How It Works:**
1.  **Main Menu:** The app opens to a main menu with options to "Add to Playlist," "View Playlist," and "Exit."
2.  **Add Songs:**
    *   Users tap "Add to Playlist."
    *   They are presented with input fields to enter the Song Title, Artist Name, Rating (e.g., 1-5), and personal Comments/Genre.
    *   Upon submission, the song is added to their local playlist data.
3.  **View Playlist:**
    *   Users tap "View Playlist."
    *   The app displays a table or list of all the songs added, showing their title, artist, rating, and comments.
4.  **Exit:** Users can close the application.

**What Problem Does It Solve?**
*   **Music Organization:** Helps users organize their favorite songs or songs they want to remember.
*   **Personalized Tracking:** Allows users to add personal context (ratings, comments/genre) to their music collection beyond just the song title and artist.
*   **Simple Management:** Provides a straightforward interface for adding and viewing song entries without complex features.

**Target Audience:**
*   Music enthusiasts who want a simple way to list and annotate songs.
*   Users who want to keep a personal log of music they've listened to and their thoughts on it.
*   Anyone needing a basic tool to create and view custom song lists.

---

🌟 **Main Features**

*   **Add Songs:** Easily input song details including title, artist, rating (1-5), and comments/genre.
*   **View Playlist:** Display all added songs in a clear, tabular format.
*   **Persistent Data (Implicit):** Songs added by the user are retained within the app session for viewing (and potentially across sessions if persistence is implemented).
*   **Intuitive Navigation:** Simple main menu with clear options.
*   **Input Validation:** Basic checks to ensure required fields (like title, artist, valid rating) are provided.

---

🎨 **Design Considerations**

**User Interface (UI):**
*   **Clarity:** Focused on clear labels for input fields and buttons.
*   **Functional Layout:** The layout is designed for easy data entry and viewing.
*   **Visual Cues:** Uses standard Android UI components for a familiar experience.
    *   *(You can add more here if you have specific color schemes, icons, or background images, e.g., "Uses a background image to provide a pleasant visual context.")*

**User Experience (UX):**
*   **Straightforward Workflow:**
    1.  User launches the app to the main menu.
    2.  Selects an action (Add, View, Exit).
    3.  If adding, fills out a form and submits.
    4.  If viewing, sees a list/table of their songs.
*   **Feedback:** Provides Toast messages for actions like successful song addition or input validation errors.
*   **Simplicity:** Avoids unnecessary complexity, focusing on core playlist functionalities.

**Performance & Technical Aspects:**
*   **Layout Efficiency:** Utilizes `ConstraintLayout` for responsive and efficient UI rendering.
*   **Data Handling:** Manages playlist data using `MutableList` in Kotlin within the `MainActivity`. Data is passed to the `ViewPlaylist` activity via Intent extras.
*   **Dynamic Table Population:** The `ViewPlaylist` activity dynamically creates `TableRow` and `TextView` elements to display the song data.
*   **Android Best Practices (In Progress):** Aims to follow Android development guidelines, including the use of `enableEdgeToEdge` and handling window insets.

---

🚀 **Development Steps Followed (Example - Please Customize)**

1.  **Project Setup:** Created a new Android Studio project with Kotlin support.
2.  **UI Design (XML):**
    *   Designed `activity_main.xml` with `EditText` fields for song input, `ImageButton`s for actions (Add, View, Exit), and a background `ImageView`.
    *   Designed `activity_view_playlist.xml` with a `TableLayout` (`R.id.tbLay1`) to display the playlist and navigation buttons.
3.  **Core Logic (`MainActivity.kt`):**
    *   Initialized `MutableList`s to store song titles, artists, ratings, and comments.
    *   Implemented `OnClickListener` for the "Add to Playlist" button:
        *   Retrieving text from `EditText` fields.
        *   Performing input validation (checking for blank fields, valid rating range).
        *   Adding valid data to the respective lists.
        *   Displaying Toast messages for feedback.
    *   Implemented `OnClickListener` for the "View Playlist" button:
        *   Creating an `Intent` to navigate to `ViewPlaylist`.
        *   Passing the song data lists as `ArrayList` extras in the Intent.
    *   Implemented `OnClickListener` for the "Exit" button using `finishAffinity()`.
4.  **Display Logic (`ViewPlaylist.kt`):**
    *   Retrieved the song data `ArrayList`s from the Intent extras.
    *   Implemented logic (initially in a button click, then moved to `onCreate` or a separate function) to:
        *   Iterate through the song data.
        *   Dynamically create `TableRow` and `TextView` objects for each song.
        *   Populate the `TextViews` with song details.
        *   Add the `TableRow` to the `TableLayout` in the XML.
    *   Implemented navigation back to the Main Menu.
5.  **Refinements & Debugging:**
    *   Addressed issues with data not appearing in the table by moving population logic.
    *   Improved input validation.
    *   Considered (and potentially implemented) using View Binding.
6.  **Documentation:** Created this README file.

---

🖼️ **App Screenshots**

*(Embed 2-4 key screenshots of your app here. For example: Main Menu, Add Song Screen, View Playlist Screen.)*

**Example:**

`![Image](https://github.com/user-attachments/assets/fa910c34-0923-4998-8c3c-d2c2007f365d)
`![Image](https://github.com/user-attachments/assets/8aaade73-e37e-480f-9477-fe94fa9af629)


---



---

📂 **Submission**

This project, including this README document, has been submitted to Arc as per the requirements.

---

📧 **Contact**

Created by: **Lubo Mbuyu**
*   📧 Email: `ST10467547@vcconnects.edu.za`
*   <!-- GitHub: [[yourusername](https://github.com/yourusername) -->](https://github.com/VCWVL/imad5112-practicum-LUBOMBUYU.git)
