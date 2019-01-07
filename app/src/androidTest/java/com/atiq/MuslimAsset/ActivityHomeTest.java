package com.atiq.MuslimAsset;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class ActivityHomeTest {

    @Rule
   public ActivityTestRule<ActivityHome> mActivityTestRule=new ActivityTestRule<>(ActivityHome.class);
    private ActivityHome  myActivity;

    @Before
    public void setUp() throws Exception {
        myActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testActivity(){
        View v = myActivity.findViewById(R.id.recycler_view);
        assertNotNull(v);
    }

    @After
    public void tearDown() throws Exception {

        myActivity=null;
    }

}