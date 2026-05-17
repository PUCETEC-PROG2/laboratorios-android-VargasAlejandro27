package ec.edu.puce.githubclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ec.edu.puce.githubclient.ui.theme.componets.RepoItem

@Composable
fun RepoList(
    modifier: Modifier = Modifier
){
    Column {
        RepoItem(
            name = "repositorio de Alejandro",
            description = "repositorio creado por Alejandro",
            avatarURL = "https://avatars.githubusercontent.com/u/191403759?v=4",
            language = "JAVAAAA"
        )
        RepoItem(
            name = "repositorio de Alejandro",
            description = "repositorio creado por Alejandro",
            avatarURL = "https://avatars.githubusercontent.com/u/191403759?v=4",
            language = "PYTHON"
        )
        RepoItem(
            name = "repositorio de Alejandro",
            description = "repositorio creado por Alejandro",
            avatarURL = "https://avatars.githubusercontent.com/u/191403759?v=4",
            language = "KOTLIN"
        )
        RepoItem(
            name = "repositorio de Alejandro",
            description = "repositorio creado por Alejandro",
            avatarURL = "https://avatars.githubusercontent.com/u/191403759?v=4",
            language = "CSS"
        )
        RepoItem(
            name = "repositorio de Alejandro",
            description = "repositorio creado por Alejandro",
            avatarURL = "https://avatars.githubusercontent.com/u/191403759?v=4",
            language = "MUDBLAZOR"
        )
    }
}