package io.github.fayaz07.tdd.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.fayaz07.tdd.R

@Composable
fun SignupScreen() {
    Scaffold {
        Content(it)
    }
}

@Composable
private fun Content(paddingValues: PaddingValues) {
    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Text(text = stringResource(id = R.string.app_name_header))

        TextField(value = name, onValueChange = { name = it })
    }
}