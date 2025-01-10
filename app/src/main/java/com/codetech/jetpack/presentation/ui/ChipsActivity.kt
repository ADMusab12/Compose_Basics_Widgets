package com.codetech.jetpack.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codetech.jetpack.presentation.Extension.AssistChipEx
import com.codetech.jetpack.presentation.Extension.FilterChipEx
import com.codetech.jetpack.presentation.Extension.InputChipEx
import com.codetech.jetpack.presentation.Extension.SuggestionChipEx
import com.codetech.jetpack.presentation.ui.ui.theme.JetpackTheme

class ChipsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    item { AssistChipEx("Assist Chip") }
                    item { FilterChipEx("Filter Chip") }
                    item { InputChipEx("Input Chip"){} }
                    item { SuggestionChipEx("Suggestions Chip") }
                }
            }
        }
    }
}
