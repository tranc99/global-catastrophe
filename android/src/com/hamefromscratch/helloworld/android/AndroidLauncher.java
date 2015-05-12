package com.hamefromscratch.helloworld.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.hamefromscratch.helloworld.InputDemo4;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGLSurfaceView20API18 = true;
        config.useAccelerometer = true;
        config.useCompass = true;


        initialize(new InputDemo4(), config);
	}
}
