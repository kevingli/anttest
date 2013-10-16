package com.example.customview.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class UITest extends UiAutomatorTestCase {
	
	// This test determines if the device is running Android 4.3
	public void testOne() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject settingsButton = new UiObject(new UiSelector().text("Settings"));
		settingsButton.clickAndWaitForNewWindow();
		
		UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
		settingsView.setAsVerticalList();
		UiObject aboutButton = settingsView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "Sound");
		aboutButton.clickAndWaitForNewWindow();
	}
}
