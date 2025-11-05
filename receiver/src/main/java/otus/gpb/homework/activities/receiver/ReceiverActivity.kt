package otus.gpb.homework.activities.receiver

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        val title = findViewById<TextView>(R.id.titleTextView)
            title.text = intent.getStringExtra("title").orEmpty()

        val year = findViewById<TextView>(R.id.yearTextView)
        year.text = intent.getStringExtra("year").orEmpty()

        val description = findViewById<TextView>(R.id.descriptionTextView)
        description.text = intent.getStringExtra("description").orEmpty()


        val imageId = when (intent.getStringExtra("title").orEmpty()) {
            "Славные парни" -> R.drawable.niceguys
            "Интерстеллар" -> R.drawable.interstellar
            else -> 0
        }

        findViewById<ImageView>(R.id.posterImageView).run {
            setImageResource(imageId)
            }


    }
}
