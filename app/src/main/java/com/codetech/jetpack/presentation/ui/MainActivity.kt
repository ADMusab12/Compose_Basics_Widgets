package com.codetech.jetpack.presentation.ui

import android.os.Bundle
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.codetech.jetpack.presentation.Extension.FilledTonalNavigation
import com.codetech.jetpack.presentation.Extension.Navigation
import com.codetech.jetpack.presentation.Extension.ShowAlertDialogButton
import com.codetech.jetpack.ui.theme.JetpackTheme
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                MainScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerContent = { DrawerContent() },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Navigation Drawer Example") },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        if (drawerState.isClosed) drawerState.open()
                                        else drawerState.close()
                                    }
                                }
                            ) {
                                Icon(Icons.Default.Menu, contentDescription = "Menu")
                            }
                        }
                    )
                }
            ) { innerPadding ->
                MainContent(innerPadding)
            }
        }
    }

    @Composable
    private fun DrawerContent() {
        ModalDrawerSheet {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.height(12.dp))
                Text(
                    "Drawer Title",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                HorizontalDivider()

                DrawerSection(
                    title = "Section 1",
                    items = listOf(
                        DrawerItem(
                            "Email",
                            icon = { Icon(Icons.Filled.Email, null) },
                            badge = { Text("20") }
                        ),
                        DrawerItem(
                            "Favourites",
                            icon = { Icon(Icons.Filled.Favorite, null) },
                            badge = { Text("12") }
                        )
                    )
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                DrawerSection(
                    title = "Section 2",
                    items = listOf(
                        DrawerItem(
                            "Settings",
                            icon = { Icon(Icons.Outlined.Settings, null) },
                            badge = { Text("2") }
                        ),
                        DrawerItem(
                            "Help and feedback",
                            icon = { Icon(Icons.AutoMirrored.Outlined.Send, null) }
                        )
                    )
                )
                Spacer(Modifier.height(12.dp))
            }
        }
    }

    @Composable
    private fun DrawerSection(
        title: String,
        items: List<DrawerItem>
    ) {
        Text(
            title,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleMedium
        )
        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.title) },
                selected = false,
                onClick = { /* Handle click */ },
                icon = item.icon,
                badge = item.badge
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainContent(paddingValues: PaddingValues) {
        var showTimePicker by remember { mutableStateOf(false) }
        var selectedTime by remember { mutableStateOf("No time selected") }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TextButton(onClick = { showTimePicker = true }) {
                    Text("Show Time Picker")
                }
                Text(text = selectedTime, modifier = Modifier.padding(top = 8.dp))
            }
            item { FilledTonalNavigation("TextViews") { Navigation(TextViewsActivity::class.java) } }
            item { FilledTonalNavigation("Buttons") { Navigation(ButtonsActivity::class.java) } }
            item { FilledTonalNavigation("CardViews") { Navigation(CardViewActivity::class.java) } }
            item { FilledTonalNavigation("Chips") { Navigation(ChipsActivity::class.java) } }
            item { FilledTonalNavigation("Indicators") { Navigation(IndicatorsActivity::class.java) } }
            item { FilledTonalNavigation("Pull to refresh") { Navigation(PullToRefreshActivity::class.java) } }
            item { ShowAlertDialogButton() }

        }

        if (showTimePicker) {
            TimePickerExample(
                onConfirm = { timePickerState ->
                    val hour = timePickerState.hour
                    val minute = timePickerState.minute
                    selectedTime = "Selected Time: ${String.format("%02d:%02d", hour, minute)}"
                    showTimePicker = false
                },
                onDismiss = { showTimePicker = false }
            )
        }
    }

    private data class DrawerItem(
        val title: String,
        val icon: (@Composable () -> Unit)? = null,
        val badge: (@Composable () -> Unit)? = null
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TimePickerExample(
        onConfirm:(TimePickerState)->Unit,
        onDismiss:()->Unit
    ){

        val currentTime = Calendar.getInstance()
        val timePickerState = rememberTimePickerState(
            initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
            initialMinute = currentTime.get(Calendar.MINUTE),
            is24Hour = true
        )

        /** Determines whether the time picker is dial or input */
        var showDial by remember{ mutableStateOf(true) }

        /** The icon used for the icon button that switches from dial to input */
        val toggleIcon = if(showDial){
            Icons.Filled.Edit
        }else{
            Icons.Filled.DateRange
        }

        TimePickerDialog(
            onDismiss = { onDismiss() },
            onConfirm = { onConfirm(timePickerState) },
            toggle = {
                IconButton(onClick = { showDial= !showDial }) {
                    Icon(imageVector = toggleIcon, contentDescription = "Time picker type toggle")
                }
            },
        ){
            if (showDial){
                TimePicker(state = timePickerState)
            }else{
                TimeInput(state = timePickerState)
            }
        }
    }

    @Composable
    private fun TimePickerDialog(
        title:String="Select time",
        onDismiss:()->Unit,
        onConfirm:()->Unit,
        toggle:  @Composable ()->Unit = {},
        content: @Composable ()->Unit
    ){
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                shape = MaterialTheme.shapes.extraLarge,
                tonalElevation = 6.dp,
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Min)
                    .background(
                        shape = MaterialTheme.shapes.extraLarge,
                        color = MaterialTheme.colorScheme.surface
                    ),
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        text = title,
                        style = MaterialTheme.typography.labelMedium
                    )
                    content()
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                    ) {
                        toggle()
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(onClick = onDismiss) { Text("Cancel")}
                        TextButton(onClick = onConfirm) { Text("Ok")}
                    }
                }
            }
        }
    }
}


