package com.example.ucsm.studentrecordmanagement;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by UCSM on 10/27/2016.
 */

public class UserSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.project_setting);

    }

}
