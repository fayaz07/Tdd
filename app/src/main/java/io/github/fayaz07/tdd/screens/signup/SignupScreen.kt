package io.github.fayaz07.tdd.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.fayaz07.tdd.R
import io.github.fayaz07.testtags.screens.SignupScreenTestTags

@Composable
fun SignupScreen() {
    Scaffold {
        Content(it)
    }
}

@Preview
@Composable
private fun Preview() {
   SignupScreen()
}

@Composable
private fun Content(paddingValues: PaddingValues) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Text(text = stringResource(id = R.string.app_name_header))

        Icon(
            painter = painterResource(id = R.drawable.icon_person),
            contentDescription = null
        )

        NameField(name) {
            name = it
        }

        EmailField(email) {
            email = it
        }

        PasswordField(password) {
            password = it
        }
    }
}

@Composable
private fun NameField(
    value: String,
    onChange: (value: String) -> Unit
) {
    TextField(
        modifier = Modifier.testTag(SignupScreenTestTags.FIELD_NAME),
        value = value,
        onValueChange = onChange,
        prefix = {
            Icon(
                painter = painterResource(id = R.drawable.icon_person),
                contentDescription = SignupScreenTestTags.FIELD_NAME_PREFIX_ICON
            )
        }
    )
}

@Composable
private fun EmailField(
    value: String,
    onChange: (value: String) -> Unit
) {
    TextField(
        modifier = Modifier.testTag(SignupScreenTestTags.FIELD_EMAIL),
        value = value,
        onValueChange = onChange,
    )
}

@Composable
private fun PasswordField(
    value: String,
    onChange: (value: String) -> Unit
) {
    TextField(
        modifier = Modifier.testTag(SignupScreenTestTags.FIELD_PASSWORD),
        value = value,
        onValueChange = onChange,
    )
}
