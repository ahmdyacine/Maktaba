package com.ElOuedUniv.maktaba.presentation.book.add

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBookView(
    onBackClick: () -> Unit,
    viewModel: AddBookViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onBackClick()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ADD BOOK", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header buttons Cancel / Confirm
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Cancel",
                    modifier = Modifier.clickable { onBackClick() },
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Confirm",
                    modifier = Modifier.clickable { viewModel.onAction(AddBookUiAction.OnAddClick) },
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            // Cover Image Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    .clickable { /* TODO: Pick image */ },
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.AddPhotoAlternate,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "ADD COVER IMAGE",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            OutlinedTextField(
                value = uiState.title,
                onValueChange = { viewModel.onAction(AddBookUiAction.OnTitleChange(it)) },
                label = { Text("Book Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = uiState.isbn,
                onValueChange = { viewModel.onAction(AddBookUiAction.OnIsbnChange(it)) },
                label = { Text("ISBN") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = uiState.nbPages,
                onValueChange = { viewModel.onAction(AddBookUiAction.OnPagesChange(it)) },
                label = { Text("Pages") },
                modifier = Modifier.fillMaxWidth(),

            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Button(
                onClick = { viewModel.onAction(AddBookUiAction.OnAddClick) },
                modifier = Modifier.fillMaxWidth(),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
            ) {
                Text("Confirm")
            }
            /*
            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancel", textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline, color = Color.Black)
            }*/
            Button(
                onClick = { viewModel.onAction(AddBookUiAction.OnAddClick) },
                modifier = Modifier.fillMaxWidth(),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
            ) {
                Text("Cancel")
            }
        }
    }
}
