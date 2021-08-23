package com.ashunevich.simplenotes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

open class RobotBase {

    fun tapBy(matcher: Matcher<View>): ViewInteraction = onView(matcher)
        .perform(ViewActions.click())

    fun tapRecyclerItem(name: String, matcher: Matcher<View>) {
        onView(matcher)
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(ViewMatchers.withText(name)), ViewActions.scrollTo()))
        onView(ViewMatchers.withText(name)).perform(ViewActions.click())
    }

    fun typeInText(text: String, matcher: Matcher<View>): ViewInteraction =
        onView(matcher)
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())

    fun replaceText(text: String, matcher: Matcher<View>): ViewInteraction =
        onView(matcher)
            .perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())


    fun removeItem(text: String, matcher: Matcher<View>) : ViewInteraction =
        onView(matcher)
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(ViewMatchers.withText(text)), swipeLeft()))


}