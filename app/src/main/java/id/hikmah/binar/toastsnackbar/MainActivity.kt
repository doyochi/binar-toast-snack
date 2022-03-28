package id.hikmah.binar.toastsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.hikmah.binar.toastsnackbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}