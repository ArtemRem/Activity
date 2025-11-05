package otus.gpb.homework.activities.sender


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.activities.receiver.R

class SenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sender)

        findViewById<Button>(R.id.button_ToGoogleMaps).setOnClickListener {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=restaurant"))
                            .setPackage("com.google.android.apps.maps")
            try { startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Не удалось открыть карты",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        findViewById<Button>(R.id.button_SendEmail).setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:android@otus.ru?subject=\"Письмо в otus \"&body=\"Домашнее задание activities_02.\""))
                try { startActivity(intent)
                } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Не удалось открыть почтовый агент",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        findViewById<Button>(R.id.button_OpenReceiver).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.type = "text/plain"
            intent.putExtra("title", "Славные парни")
            intent.putExtra("year", "2016")
            intent.putExtra("description", "Что бывает, когда напарником брутального костолома становится субтильный лопух? Наемный охранник Джексон Хили ...")
                try { startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Не удалось открыть Receiver",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}