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
import com.codetech.jetpack.presentation.Extension.ElevatedBt
import com.codetech.jetpack.presentation.Extension.FilledBt
import com.codetech.jetpack.presentation.Extension.FilledTonal
import com.codetech.jetpack.presentation.Extension.FloatingActionEx
import com.codetech.jetpack.presentation.Extension.FloatingActionExtendedEx
import com.codetech.jetpack.presentation.Extension.FloatingActionLargeEx
import com.codetech.jetpack.presentation.Extension.FloatingActionSmallEx
import com.codetech.jetpack.presentation.Extension.OutlineButton
import com.codetech.jetpack.presentation.Extension.SegmentButton
import com.codetech.jetpack.presentation.Extension.SwitchButtonEx
import com.codetech.jetpack.presentation.Extension.TextBt
import com.codetech.jetpack.ui.theme.JetpackTheme

class ButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    item { FilledBt(text = "Filled") }
                    item { FilledTonal(text = "Filled Tonal") }
                    item { OutlineButton(text = "Outlined") }
                    item { ElevatedBt(text = "Elevated") }
                    item { TextBt(text = "Text") }
                    item { SwitchButtonEx() }
                    item { SegmentButton() }
                    item { FloatingActionEx() }
                    item { FloatingActionSmallEx() }
                    item { FloatingActionLargeEx() }
                    item { FloatingActionExtendedEx() }
                }
            }
        }
    }
}
