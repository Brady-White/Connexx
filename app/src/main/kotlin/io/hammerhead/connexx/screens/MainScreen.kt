package io.hammerhead.connexx.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import io.hammerhead.connexx.KarooViewModel
import io.hammerhead.karooext.KarooSystemService
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import io.hammerhead.connexx.R
import io.hammerhead.connexx.theme.AppTheme

@Composable
fun MainScreen() {
    val context: Context = LocalContext.current
    val karooViewModel: KarooViewModel = viewModel()
    val karooService = remember { KarooSystemService(context) }

    LaunchedEffect(Unit) {
        karooViewModel.initialize(karooService)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = stringResource(id = R.string.hello_karoo), color = MaterialTheme.colorScheme.onBackground)
    }
}
