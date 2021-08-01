package tk.mystmirror.prototypearch.ui.activities.main

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import tk.mystmirror.core.util.base.MVVMActivity
import tk.mystmirror.prototypearch.R
import tk.mystmirror.prototypearch.ui.fragments.main.MainFragment

class MainActivity : MVVMActivity<MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override val viewModel: MainActivityViewModel by viewModel()
}