package io.github.fayaz07.tdd

import androidx.annotation.DrawableRes
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.test.SemanticsMatcher

val DRAWABLE_RES_ID = SemanticsPropertyKey<Int>("DrawableResId")
//var SemanticsPropertyReceiver.drawableId by DRAWABLE_RES_ID

val DrawableId = SemanticsPropertyKey<Int>("DrawableResId")
var SemanticsPropertyReceiver.drawableId by DrawableId
fun hasDrawable(@DrawableRes id: Int): SemanticsMatcher =
    SemanticsMatcher.expectValue(DrawableId, id)

object TestUtils {
//    fun matchesDrawable(@DrawableRes id: Int) =
//        SemanticsMatcher.expectValue(drawableId, id)
}
