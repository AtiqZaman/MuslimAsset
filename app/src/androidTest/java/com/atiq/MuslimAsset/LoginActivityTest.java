package com.atiq.MuslimAsset;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule=new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity myActivity;

    @Before
    public void setUp() throws Exception {
        myActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testActivity(){
        View v = myActivity.findViewById(R.id.buttonSignin);
        assertNotNull(v);

        View v1 = myActivity.findViewById(R.id.textViewSignUp);
        assertNotNull(v1);

        View v2 = myActivity.findViewById(R.id.textView);
        assertNotNull(v2);
    }

    @After
    public void tearDown() throws Exception {

        myActivity=null;
    }

}