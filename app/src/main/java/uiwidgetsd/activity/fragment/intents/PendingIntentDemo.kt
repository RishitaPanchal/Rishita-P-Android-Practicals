package uiwidgetsd.activity.fragment.intents

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_java_practicalss.R

class PendingIntentDemo : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager
    private lateinit var builder: Notification.Builder
    private val channelId = "12345"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_intent_demo)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun notify(view: View) {
        val intent = Intent(this, PendingIntent2::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        builder = Notification.Builder(this, channelId)
            .setContentTitle("NOTIFICATION PENDING INTENT ")
            .setContentText("DEMO Notification")
            .setSmallIcon(R.drawable.ic_shopping_cart)
            .setContentIntent(pendingIntent)

        notificationManager.notify(12345, builder.build())
    }

}
