package com.codetech.jetpack.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codetech.jetpack.presentation.ui.ui.theme.JetpackTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PullToRefreshActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                PullToRefreshExample()
            }
        }
    }

    @Composable
    private fun PullToRefreshExample() {
        var refreshing by remember { mutableStateOf(false) }
        var itemList by remember { mutableStateOf(List(20) {"Item ${it+1}"}) }
        
        Scaffold { paddingValues ->
            PullToRefresh(
                items = itemList,
                isRefreshing = refreshing,
                onRefresh = {
                    refreshing = true
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        itemList = List(20){ "Updated Item ${it + 1}" }
                        refreshing = false
                    }
                },
                modifier = Modifier.padding(paddingValues)
            )
        }
    }

    @Composable
    private fun PullToRefresh(
        items: List<String>,
        isRefreshing: Boolean,
        onRefresh: () -> Unit,
        modifier: Modifier = Modifier
    ) {

        val refreshState = rememberSwipeRefreshState(isRefreshing)

        SwipeRefresh(state = refreshState, onRefresh = onRefresh, modifier = modifier ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items){ item->
                    ListItem(
                        headlineContent = { Text(item)},
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 3.dp)
                    )
                }
            }
        }
    }
}
