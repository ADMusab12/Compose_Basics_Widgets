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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.codetech.jetpack.R
import com.codetech.jetpack.presentation.Extension.ElevatedCardV
import com.codetech.jetpack.presentation.Extension.FilledCard
import com.codetech.jetpack.presentation.Extension.GradientText
import com.codetech.jetpack.presentation.Extension.MarqueText
import com.codetech.jetpack.presentation.Extension.MultipleStyleText
import com.codetech.jetpack.presentation.Extension.OutlinedCardV
import com.codetech.jetpack.presentation.Extension.ShadowedTextView
import com.codetech.jetpack.presentation.Extension.SimpleCard
import com.codetech.jetpack.ui.theme.JetpackTheme

class TextViewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    item { ShadowedTextView(stringResource(R.string.hello_android)) }
                    item { MultipleStyleText("H","ello ","A","ndroid") }
                    item { GradientText(stringResource(R.string.when_you_land_on_a_sample_web_page_or_open_an_email_template_and_see_content_beginning_with_lorem_ipsum_n_the_page_creator_placed_that_apparent_gibberish_there_on_purpose_n_page_layouts_look_better_with_something_in_each_section_n_web_page_designers_content_writers_and_layout_artists_use_lorem_ipsum_also_known_as_placeholder_copy_nto_distinguish_which_areas_on_a_page_will_hold_advertisements_editorials_and_filler_before_the_final_written_content_and_website_designs_receive_client_approval_n_fun_lorem_ipsum_text_may_appear_in_any_size_and_font_to_simulate_everything_you_create_for_your_campaigns)) }
                    item { MarqueText(stringResource(R.string.hello_jetpack_compose_there_are_many_variations_of_passages_of_lorem_ipsum_available)) }
                }
            }
        }
    }
}
