package io.github.fayaz07.tdd.screens.login

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import io.github.fayaz07.tdd.ui.theme.TddTheme
import org.junit.Rule
import org.junit.Test

class SignupScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_signup_screen_is_launched_should_show_basic_signup_elements() {
        composeTestRule.setContent {
            TddTheme {
                SignupScreen()
            }
        }
        // check if app name text exists
        composeTestRule.onNodeWithText("Tdd App").assertIsDisplayed()

        // name field tag
        composeTestRule.onNodeWithTag("field-name")
            .assertIsDisplayed()
            .assertIsEnabled()

        // email field tag
        composeTestRule.onNodeWithTag("field-email")
            .assertIsDisplayed()
            .assertIsEnabled()

        // password field tag
        composeTestRule.onNodeWithTag("field-password")
            .assertIsDisplayed()
            .assertIsEnabled()

        // password field should have a suffix eye icon
        composeTestRule.onNodeWithTag("field-password-suffix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()

        // password field should have a prefix lock icon
        composeTestRule.onNodeWithTag("field-password-prefix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasNoClickAction()

        // signup button
        composeTestRule.onNodeWithTag("btn-signup")
            .assertIsDisplayed()
            .assertHasClickAction()
            .assertIsNotEnabled()
    }

    @Test
    fun on_signup_screen_user_can_perform_signup_operations() {
        composeTestRule.setContent {
            TddTheme {
                SignupScreen()
            }
        }

        // name field tag
        composeTestRule.onNodeWithTag("field-name")
            .performTextInput("Mohammad Fayaz")

        composeTestRule.onNodeWithText("Mohammad Fayaz")
            .assertIsDisplayed()
            .assertIsFocused()

        // email field tag
        composeTestRule.onNodeWithTag("field-email")
            .performTextInput("fayaz@fayaz.com")

        composeTestRule.onNodeWithText("fayaz@fayaz.com")
            .assertIsDisplayed()
            .assertIsFocused()

        // password field tag
        composeTestRule.onNodeWithTag("field-password")
            .performTextInput("Fayaz@123")

        composeTestRule.onNodeWithText("Fayaz@123")
            .assertIsDisplayed()
            .assertIsFocused()

        // password field should have a suffix eye icon
        composeTestRule.onNodeWithTag("field-password-suffix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()

        // password field should have a prefix lock icon
        composeTestRule.onNodeWithTag("field-password-prefix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasNoClickAction()

        // signup button
        composeTestRule.onNodeWithTag("btn-signup")
            .assertIsDisplayed()
            .assertHasClickAction()
            .assertIsNotEnabled()
    }
}
