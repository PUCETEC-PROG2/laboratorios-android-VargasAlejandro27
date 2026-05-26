package ec.edu.puce.githubclient.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.models.GithubUser
import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.ui.theme.componets.RepoItem
import ec.edu.puce.githubclient.viewmodels.RepoListViewModel

@Composable
fun RepoList(
    modifier: Modifier = Modifier,
    viewModel: RepoListViewModel = viewModel(),
    onNavigatetoForm: () -> Unit = {}
) {

    val repos by viewModel.repos.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMsg by viewModel.errorMsg.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchRepos()
    }

    RepoListContent(
        repos = repos,
        isLoading = isLoading,
        errorMsg = errorMsg,
        onAddClick = onNavigatetoForm,
        modifier = modifier
    )
}

@Composable
fun RepoListContent(
    repos: List<Repository>,
    isLoading: Boolean,
    errorMsg: String?,
    onAddClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        floatingActionButton = {
            if(!isLoading && errorMsg == null)
            FloatingActionButton(
                onClick = onAddClick,
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            if (isLoading) {

                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            errorMsg?.let {

                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(all = 16.dp)
                )
            }

            if (!isLoading && errorMsg == null) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(repos) { repo ->

                        RepoItem(repository = repo)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoListPreview() {
    RepoListContent(
        repos = listOf(
            Repository(
                id = "1",
                name = "Sample Repo",
                owner = GithubUser(id = "1", login = "user", avatarUrl = ""),
                description = "Sample Description",
                language = "Kotlin"
            )
        ),
        isLoading = false,
        errorMsg = null
    )
}
