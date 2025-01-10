package com.codetech.jetpack.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Extension {

    //todo non compose functions
    //todo navigation
    fun Activity.Navigation(destination:Class<*>){
        startActivity(Intent(this,destination))
    }

    //todo navigation
    fun Context.ShowToast(text: String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    //todo composable functions
    //todo shadowed textview
    @Composable
    fun Activity.ShadowedTextView(text: String) {
        val offset = Offset(5.0f,10.0f)
        Text(
            modifier = Modifier.padding(20.dp),
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Black, offset = offset, blurRadius = 2f
                )
            )
        )
    }

    //todo multiple styles
    @Composable
    fun Activity.MultipleStyleText(firstBreak:String,firstRemaining:String,secondBreak:String,secondRemaining:String){
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 24.sp)){
                    append(firstBreak)
                }
                append(firstRemaining)

                withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold,fontSize = 26.sp)){
                    append(secondBreak)
                }
                append(secondRemaining)
            }
        )
    }

    //todo multiple styles
    private val colorList = listOf(Color.Cyan,Color.LightGray,Color.Green)
    @Composable
    fun Activity.GradientText(text: String){
        Text(
            text = text,
            modifier = Modifier.padding(20.dp),
            style = TextStyle(
                fontSize = 17.sp,
                brush = Brush.linearGradient(colors = colorList)
            )
        )
    }

    //todo marque text
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Activity.MarqueText(text: String){
        Column(modifier = Modifier
            .width(300.dp)
            .padding(top = 20.dp, bottom = 20.dp)) {
            Text(
                style = TextStyle(color = Color.Blue, background = Color.LightGray),
                text = text,
                modifier = Modifier.basicMarquee(),
                fontSize = 25.sp,
            )
        }
    }

    //todo buttons
    //todo Tonal button
    @Composable
    fun Activity.FilledTonalNavigation(text:String,onClick: () -> Unit) {
        FilledTonalButton(modifier = Modifier.padding(10.dp),onClick = { onClick()}) {
            Text(text)
        }
    }

    //todo Tonal button
    @Composable
    fun Activity.FilledTonal(text:String) {
        FilledTonalButton(modifier = Modifier.padding(5.dp),onClick = { this.ShowToast("Filled Tonal Button Click")}) {
            Text(text)
        }
    }

    //todo filled Button
    @Composable
    fun Activity.FilledBt(text:String){
        Button(modifier = Modifier.padding(5.dp),onClick = {this.ShowToast("Filled Button Click")}) {
            Text(text)
        }
    }
    
    //todo outlined button
    @Composable
    fun Activity.OutlineButton(text:String){
        OutlinedButton(modifier = Modifier.padding(5.dp),onClick = {this.ShowToast("Outlined Button Click")}) {
            Text(text)
        }
    }

    //todo elevated button
    @Composable
    fun Activity.ElevatedBt(text:String){
        ElevatedButton(modifier = Modifier.padding(5.dp), onClick = {this.ShowToast("Elevated Button Click")}) {
            Text(text)
        }
    }

    //todo text button
    @Composable
    fun Activity.TextBt(text:String){
        TextButton(modifier = Modifier.padding(5.dp),onClick = {this.ShowToast("Text Button Click")}) {
            Text(text)
        }
    }

    //todo floating action button
    @Composable
    fun Activity.FloatingActionEx() {
        FloatingActionButton(
            modifier = Modifier.padding(5.dp),
            onClick = { this.ShowToast("Floating Action Button Click") }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
    }

    //todo floating action small button
    @Composable
    fun Activity.FloatingActionSmallEx() {
        SmallFloatingActionButton(
            modifier = Modifier.padding(5.dp),
            onClick = { this.ShowToast("Small Floating Action Button Click") },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
    }

    //todo floating action large button
    @Composable
    fun Activity.FloatingActionLargeEx() {
        LargeFloatingActionButton(
            modifier = Modifier.padding(5.dp),
            onClick = { this.ShowToast("Large Floating Action Button Click") },
            shape = CircleShape
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
    }

    //todo floating action extended button
    @Composable
    fun Activity.FloatingActionExtendedEx() {
        ExtendedFloatingActionButton(
            onClick = { this.ShowToast("Extended Floating Action Button Click") },
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
        )
    }

    //todo segment button
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Activity.SegmentButton() {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val options = listOf("Day","Week","Month")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = {selectedIndex = index},
                    selected = index == selectedIndex,
                    label = { Text(label)}
                )
            }
        }
    }


    //todo switch button
    @Composable
    fun Activity.SwitchButtonEx(){
        var checked by remember { mutableStateOf(false) }
        
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            thumbContent = if (checked){
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null ,
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            }else{
                null
            }
        )
    }

    //todo Card Views
    //todo simple Card
    @Composable
    fun Activity.SimpleCard(text: String){
        Card(modifier = Modifier
            .width(220.dp)
            .height(120.dp)
            .padding(15.dp)) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text)
            }
        }
    }

    //todo filled Card
    @Composable
    fun Activity.FilledCard(text: String){
        Card(
            modifier = Modifier
                .width(220.dp)
                .height(120.dp)
                .padding(15.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text)
            }
        }
    }

    //todo elevated Card
    @Composable
    fun Activity.ElevatedCardV(text: String){
        androidx.compose.material3.ElevatedCard(
            modifier = Modifier
                .width(220.dp)
                .height(120.dp)
                .padding(15.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text)
            }
        }
    }

    //todo outlined Card
    @Composable
    fun Activity.OutlinedCardV(text: String){
        androidx.compose.material3.OutlinedCard(
            modifier = Modifier
                .width(220.dp)
                .height(120.dp)
                .padding(15.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text)
            }
        }
    }

    //todo chips
    //todo assist chip
    @Composable
    fun Activity.AssistChipEx(text: String){
        AssistChip(
            modifier = Modifier.padding(15.dp),
            onClick = {},
            label = { Text(text) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "",Modifier.size(AssistChipDefaults.IconSize))
            }
        )
    }

    //todo filter chip
    @Composable
    fun Activity.FilterChipEx(text: String){
        var selected by remember { mutableStateOf(false) }

        FilterChip(
            modifier = Modifier.padding(15.dp),
            selected = selected,
            onClick = { selected = !selected },
            label = { Text(text) },
            leadingIcon = if (selected) {
                {
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "", modifier = Modifier.size(FilterChipDefaults.IconSize))
                }
            } else {
                null
            },
        )
    }

    //todo input chip
    @Composable
    fun Activity.InputChipEx(text: String,onDismiss:()->Unit){
        var enabled by remember { mutableStateOf(false) }

        InputChip(
            modifier = Modifier.padding(15.dp),
            selected = enabled,
            onClick = {
                onDismiss()
                enabled = !enabled
            },
            label = { Text(text) },
            avatar = {
                Icon(imageVector = Icons.Filled.Person, contentDescription ="",Modifier.size(InputChipDefaults.AvatarSize))
            },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "",Modifier.size(InputChipDefaults.AvatarSize))
            }
        )
    }

    //todo suggestion chip
    @Composable
    fun SuggestionChipEx(text: String) {
        SuggestionChip(
            modifier = Modifier.padding(15.dp),
            onClick = {},
            label = { Text(text) }
        )
    }

    //todo composable dialog
    @Composable
    private fun Activity.AlertDialogEx(
        onDismiss:()->Unit,
        onConfirm:()->Unit,
        dialogTitle:String,
        dialogText:String,
        icon:ImageVector
    ){
        AlertDialog(
            icon = { Icon(imageVector = icon, contentDescription ="") },
            title = {Text(text = dialogTitle)},
            text = {Text(text = dialogText)},
            onDismissRequest = { onDismiss()},
            confirmButton = { 
                TextButton(onClick = { onConfirm() }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("Dismiss")
                }
            }
        )
    }

    //todo showing dialog
    @Composable
    fun Activity.ShowAlertDialogButton() {
        var showDialog by remember { mutableStateOf(false) }

        FilledTonalButton(modifier = Modifier.padding(5.dp),onClick = { showDialog = true }) { Text("Show Dialog") }

        if (showDialog) {
            AlertDialogEx(
                onDismiss = { showDialog = false },
                onConfirm = { showDialog = false },
                dialogTitle = "Confirm Action",
                dialogText = "Are you sure you want to proceed?",
                icon = Icons.Filled.Warning
            )
        }
    }

    //todo circular progresss indicator
    @Composable
    fun Activity.CircularProgress(){
        var loading by remember { mutableStateOf(false) }

        Button(modifier = Modifier.padding(top = 30.dp),onClick = { loading = true }, enabled = !loading) {
            Text(text = "Circular Indicator")
        }

        if (!loading){
            return
        }

        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .padding(top = 30.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }

    //todo linear progresss indicator
    @Composable
    fun Activity.LinearProgress(){
        var loading by remember { mutableStateOf(false) }

        Button(modifier = Modifier.padding(top = 30.dp), onClick = { loading = true }, enabled = !loading) {
            Text(text = "Linear Indicator")
        }

        if (!loading){
            return
        }

        LinearProgressIndicator(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 30.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }

}