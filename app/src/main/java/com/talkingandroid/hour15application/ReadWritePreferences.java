package com.talkingandroid.hour15application;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;

public class ReadWritePreferences extends Activity {
    public static final String SETTINGS = "com.talkingandroid.hour15application.settings";
    public static final String FIRST_USE_SETTING = "com.talkingandroid.hour15application.firstUse";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_preferences);
        textView = (TextView) findViewById(R.id.textView);
        // Get Preferences
        SharedPreferences preferences = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        // Read the FIRST_USE_SETTING
        boolean firstUse = preferences.getBoolean(FIRST_USE_SETTING, true);
        if (firstUse){
            textView.setText(R.string.first_time_message);
            // Create Preferences Editor and update settings
            Editor editor = preferences.edit();
            editor.putBoolean(FIRST_USE_SETTING, false);
            editor.commit();
        } else{
            textView.setText(R.string.return_user_message);
        }
    }
}
