package com.hamefromscratch.helloworld.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hamefromscratch.helloworld.GraphicsDemo;
import com.hamefromscratch.helloworld.PixelMapDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Hello Tomahawk";
		config.width = 480;
		config.height = 320;
		new LwjglApplication(new GraphicsDemo(), config);
	}
}
