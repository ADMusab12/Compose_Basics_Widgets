package com.codetech.jetpack.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codetech.jetpack.presentation.Extension.ElevatedCardV
import com.codetech.jetpack.presentation.Extension.FilledCard
import com.codetech.jetpack.presentation.Extension.FilledTonalNavigation
import com.codetech.jetpack.presentation.Extension.Navigation
import com.codetech.jetpack.presentation.Extension.OutlinedCardV
import com.codetech.jetpack.presentation.Extension.SimpleCard
import com.codetech.jetpack.presentation.ui.ui.theme.JetpackTheme

class CardViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    item { SimpleCard("Simple Card View") }
                    item { FilledCard("Filled Card View") }
                    item { ElevatedCardV("Elevated Card View") }
                    item { OutlinedCardV("Outlined Card View") }
                }
            }
        }
    }
}
