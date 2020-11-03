package com.pjuaneda.shifumi

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test


class GameFragmentInstrumentedTest {

    @Test
    fun testGameFragmentHumanIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.home_play_human))
            .perform(click())

        onView(withId(R.id.game_toolbar))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_scissors))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_rock))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_paper))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_score_first))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_score_second))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_scores_first_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_scores_second_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_computer))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @Test
    fun testGameFragmentComputerIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.home_play_computer))
            .perform(click())

        onView(withId(R.id.game_toolbar))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_scissors))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.game_play_rock))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.game_play_paper))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.game_score_first))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_score_second))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_scores_first_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_scores_second_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.game_play_computer))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testGameFragmentPlayRock() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.home_play_human))
            .perform(click())

        onView(withId(R.id.game_play_rock))
            .perform(click())

        onView(withId(R.id.game_hand_first))
            .check(matches(withContentDescription(R.string.game_actions_rock_content)))
    }
    @Test
    fun testGameFragmentPlayPaper() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.home_play_human))
            .perform(click())

        onView(withId(R.id.game_play_paper))
            .perform(click())

        onView(withId(R.id.game_hand_first))
            .check(matches(withContentDescription(R.string.game_actions_paper_content)))
    }

    @Test
    fun testGameFragmentPlayScissors() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.home_play_human))
            .perform(click())

        onView(withId(R.id.game_play_scissors))
            .perform(click())

        onView(withId(R.id.game_hand_first))
            .check(matches(withContentDescription(R.string.game_actions_scissors_content)))
    }

}