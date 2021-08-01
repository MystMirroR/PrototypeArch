package tk.mystmirror.core_db.prefs

import android.content.Context
import android.content.SharedPreferences
import com.fredporciuncula.flow.preferences.FlowSharedPreferences
import com.fredporciuncula.flow.preferences.Preference
import kotlinx.coroutines.ExperimentalCoroutinesApi

class Preferences(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("config", Context.MODE_PRIVATE)

    @ExperimentalCoroutinesApi
    private val flowSharedPreferences: FlowSharedPreferences = FlowSharedPreferences(preferences)


    @ExperimentalCoroutinesApi
    var testValue: Preference<String> =
        flowSharedPreferences.getString("key", defaultValue = "test")

}