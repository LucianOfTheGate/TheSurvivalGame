package com.example.annax.survivalgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MotionEvent;
import android.widget.Button;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by lucas on 11/20/2017.
 */

public class ScoreFragmentTest extends ActivityInstrumentationTestCase2<ScoresActivity> {

    private ScoresActivity mTestActivity;
    private ScoreFragment mTestFragment;
    private Button mEnterName;
    private SharedPreferences mScoreMap;

    public ScoreFragmentTest() {
        super(ScoresActivity.class);
    }

    protected void tearDown() throws Exception {
        mTestActivity.finish();
        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mTestActivity = getActivity();
        mTestFragment = new ScoreFragment();
        mTestActivity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mTestFragment, null).commit();
        getInstrumentation().waitForIdleSync();
        setActivityInitialTouchMode(false);
        mEnterName = (Button) mTestFragment.getView().findViewById(R.id.enterName);
        mScoreMap = (SharedPreferences) mTestFragment.getActivity().getPreferences(Context.MODE_PRIVATE);
    }

    @Test
    public void testPreconditions() {
        assertNotNull("Activity is Null", mTestActivity);
        assertNotNull("Fragment is Null", mTestFragment);
        assertNotNull("Button is Null", mEnterName);
    }

    @Test
    public void testUI() {
        System.out.println("Thread ID in testUI.run:" + Thread.currentThread().getId());
        getInstrumentation().waitForIdleSync();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread ID in TestUI.run: " + Thread.currentThread().getId());
                mEnterName.requestFocus();
                MotionEvent newMotionEvent = MotionEvent.obtain((long) 1, (long) 1, MotionEvent.ACTION_DOWN, (float) 53.0, (float) 53.0, 0);
                mEnterName.dispatchTouchEvent(newMotionEvent);
                assertTrue(mTestFragment.isVisible()); //Obviously not useful. Simply to help me understand how to view thread testing.
            }
        });
    }

    @Test
    public void quickTestOfJUnitEnvironment() {
        assertTrue(true);
    }

    @Test
    public void pressEnterNameTest() {
        onView(withId(R.id.enterName)).check(matches(isEnabled()));
    }

    @Test
    public void testSharedPreferences() {
        onView(withId(R.id.enterName)).check(matches(isEnabled()));
    }
/*
    @Test
    public void addScoreToSharedPreferenceTest() {
        //R.class.getClass().getMethod("on");
    }
*/

}
