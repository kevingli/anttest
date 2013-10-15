package com.example.customview.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class UITest extends UiAutomatorTestCase {
	
	public void testDemo() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject settingsButton = new UiObject(new UiSelector().text("Settings"));
		settingsButton.clickAndWaitForNewWindow();
		
		UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
		settingsView.setAsVerticalList();
		UiObject aboutButton = settingsView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "About phone");
		aboutButton.clickAndWaitForNewWindow();
		
		UiScrollable aboutView = new UiScrollable(new UiSelector().scrollable(true));
	    settingsView.setAsVerticalList();		
	    UiObject modelNumber = aboutView.getChild(new UiSelector().text("Nexus 4"));
	    assertTrue(modelNumber.getText().equals("Nexus 4"));
	}
}
