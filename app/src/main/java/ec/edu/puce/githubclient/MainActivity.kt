package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ec.edu.puce.githubclient.ui.theme.screens.RepoForm
import ec.edu.puce.githubclient.ui.theme.screens.RepoList
import ec.edu.puce.githubclient.ui.theme.theme.GithubClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentScreen by remember { mutableStateOf("repolist") }
            GithubClientTheme {
                when(currentScreen) {
                    "repolist" -> RepoList(
                        onNavigatetoForm = { currentScreen = "repoform" }
                    )
                    "repoform" -> RepoForm(
                        onBackClick = { currentScreen = "repolist" }
                    )
                }
            }
        }
    }
}
