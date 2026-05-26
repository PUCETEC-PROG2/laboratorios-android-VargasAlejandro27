package ec.edu.puce.githubclient.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ec.edu.puce.githubclient.ui.theme.theme.GithubClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoForm(
    onBackClick: () -> Unit = {}
) {
    // Definimos el estado para los campos de texto
    var repoName by remember { mutableStateOf("") }
    var repoDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nuevo repositorio") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy (space = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = repoName,
                    onValueChange = { repoName = it },
                    label = { Text(text = "Nombre del Repositorio") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                OutlinedTextField(
                    value = repoDescription,
                    onValueChange = { repoDescription = it },
                    label = { Text(text = "Descripción") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 4
                )
                Button(
                    onClick = { 
                        // Aquí iría la lógica para guardar el repositorio
                        println("Guardando: $repoName - $repoDescription")
                    },
                    enabled = repoName.isNotBlank(), // El botón solo se activa si hay un nombre
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Guardar"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Guardar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoFormPreview() {
    GithubClientTheme {
        RepoForm()
    }
}
