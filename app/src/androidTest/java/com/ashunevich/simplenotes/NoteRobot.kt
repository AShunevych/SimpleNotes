package com.ashunevich.simplenotes

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

fun noteRobot(func: NoteRobot.() -> Unit) = NoteRobot().apply { func() }


class NoteRobot : RobotBase() {

    private val submitNote: Matcher<View> = ViewMatchers.withId(R.id.submitButton)
    private val tagField: Matcher<View> = ViewMatchers.withId(R.id.tagText)
    private val noteField: Matcher<View> = ViewMatchers.withId(R.id.noteText)

    fun tapOnSubmitButton() = tapBy(submitNote)

    fun setTag(tag: String)  = typeInText(tag,tagField)

    fun setText(text: String)  = typeInText(text,noteField)

    fun replaceText(text: String) = replaceText(text,noteField)

    fun replaceTag(tag: String) = replaceText(tag,tagField)
}