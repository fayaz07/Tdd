package io.github.fayaz07.tdd

import androidx.annotation.DrawableRes
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.SemanticsMatcher

object TestUtils {
    private val DRAWABLE_RES_ID = SemanticsPropertyKey<Int>("DrawableResId")

    fun matchesDrawable(@DrawableRes id: Int) =
        SemanticsMatcher.expectValue(DRAWABLE_RES_ID, id)
}
