package com.ashunevich.simplenotes

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher

fun mainScreenRobot(func: MainScreenRobot.() -> Unit) = MainScreenRobot().apply { func() }

class MainScreenRobot : RobotBase() {

    private val createNewNote: Matcher<View> = withId(R.id.addNewNote)
    private val recyclerView: Matcher<View> = withId(R.id.recyclerView)

    fun createItem() = tapBy(createNewNote)

    fun updateItem(itemName: String) = tapRecyclerItem(itemName,recyclerView)

    fun removeItem(itemName: String) = removeItem(itemName,recyclerView)

}