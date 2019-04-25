package com.moovel.android.coding.challenge

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
  @get:Rule val activityRule = ActivityTestRule(MainActivity::class.java)

  @Test fun sampleTest() {
    // Only a sample test which you can adjust and to get you started easily.
    onView(withId(R.id.activityMainTextView)).check(matches(withText("Hello World")))
  }
}
