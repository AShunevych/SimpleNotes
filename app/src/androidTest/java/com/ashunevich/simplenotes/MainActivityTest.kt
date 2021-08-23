package com.ashunevich.simplenotes

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(Utils.idlingResource)
    }

    @Test
    fun createNewNoteTest(){

        mainScreenRobot{
            tapOnButton()
        }
        noteRobot {
            setTag("tag")
            setText("string")
            tapOnSubmitButton()
        }
    }

    @Test
    fun updateNote(){
        mainScreenRobot{
            updateItem("tag")
        }
        noteRobot {
            replaceTag("new Tag")
            replaceText("new Text")
            tapOnSubmitButton()
        }
    }


    @Test
    fun deleteNote(){
        mainScreenRobot{
            removeItem("new Tag")
        }

    }


    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(Utils.idlingResource)
    }

}