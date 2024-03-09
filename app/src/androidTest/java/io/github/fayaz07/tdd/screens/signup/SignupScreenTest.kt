package io.github.fayaz07.tdd.screens.signup

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onParent
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTextInput
import io.github.fayaz07.tdd.R
import io.github.fayaz07.tdd.TestUtils.matchesDrawable
import io.github.fayaz07.tdd.ui.theme.TddTheme
import io.github.fayaz07.testtags.screens.SignupScreenTestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignupScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            TddTheme {
                SignupScreen()
            }
        }
    }

    @Test
    fun when_signup_screen_is_launched_should_show_header_text() {
        // check if app name text exists
        composeTestRule.onNodeWithText("Tdd App").assertIsDisplayed()
    }

    @Test
    fun when_signup_screen_is_launched_should_show_name_field() {
        // name field tag
        composeTestRule.onNodeWithTag(SignupScreenTestTags.FIELD_NAME)
            .assertIsDisplayed()
            .assertIsEnabled()

        composeTestRule.onNodeWithTag(SignupScreenTestTags.FIELD_NAME)
            .performTextInput("Mohammad Fayaz")

        composeTestRule.onNodeWithText("Mohammad Fayaz")
            .assertIsDisplayed()
            .assertIsFocused()

        composeTestRule.onNode(matchesDrawable(R.drawable.icon_person))
    }

    @Test
    fun when_signup_screen_is_launched_should_show_email_field() {
        // email field tag
        composeTestRule.onNodeWithTag(SignupScreenTestTags.FIELD_EMAIL)
            .assertIsDisplayed()
            .assertIsEnabled()

        composeTestRule.onNodeWithTag(SignupScreenTestTags.FIELD_EMAIL)
            .performTextInput("fayaz@fayaz.com")

        composeTestRule.onNodeWithText("fayaz@fayaz.com")
            .assertIsDisplayed()
            .assertIsFocused()
    }

    @Test
    fun when_signup_screen_is_launched_should_show_password_field() {
        // password field tag
        composeTestRule.onNodeWithTag("field-password")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun when_signup_screen_is_launched_should_show_password_fields_suffix_icon() {
        // password field should have a suffix eye icon
        composeTestRule.onNodeWithTag("field-password-suffix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()
    }

    @Test
    fun when_signup_screen_is_launched_should_show_password_fields_prefix_icon() {
        // password field should have a prefix lock icon
        composeTestRule.onNodeWithTag("field-password-prefix")
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasNoClickAction()
    }

    @Test
    fun when_signup_screen_is_launched_should_show_signup_button() {
        // signup button
        composeTestRule.onNodeWithTag("btn-signup")
            .assertIsDisplayed()
            .assertHasClickAction()
            .assertIsNotEnabled()
    }

    @Test
    fun on_signup_screen_user_can_perform_signup_operations() {
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
