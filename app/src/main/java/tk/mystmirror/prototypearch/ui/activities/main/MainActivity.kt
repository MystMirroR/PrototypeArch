package tk.mystmirror.prototypearch.ui.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tk.mystmirror.prototypearch.R
import tk.mystmirror.prototypearch.ui.fragments.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}