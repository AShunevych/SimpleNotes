package com.ashunevich.simplenotes

import androidx.test.espresso.idling.CountingIdlingResource

object Utils {

    val idlingResource = CountingIdlingResource("idlRes");
}