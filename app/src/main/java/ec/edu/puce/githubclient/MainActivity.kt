package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.ui.theme.screens.RepoForm
import ec.edu.puce.githubclient.ui.theme.screens.RepoList
import ec.edu.puce.githubclient.ui.theme.theme.GithubClientTheme
import ec.edu.puce.githubclient.viewmodels.RepoListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentScreen by remember { mutableStateOf("repolist") }
            val listViewModel : RepoListViewModel = viewModel ()
            GithubClientTheme {
                when(currentScreen) {
                    "repolist" -> RepoList(
                        onNavigatetoForm = { currentScreen = "repoform" }
                    )
                    "repoform" -> RepoForm(
                        onBackClick = { currentScreen = "repolist" },
                        onSaveSuccess = {
                            listViewModel.fetchRepos()
                            currentScreen = "repolist" }


                        )

                }
            }
        }
    }
}
