package tk.mystmirror.prototypearch.ui.activities.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import tk.mystmirror.core.util.base.MVVMActivity
import tk.mystmirror.prototypearch.R

class MainActivity : MVVMActivity<MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottom_navigation.setupWithNavController(navController)
    }


    override val viewModel: MainActivityViewModel by viewModel()
}