package com.example.customview.test;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class UITest extends UiAutomatorTestCase {
	
	// This test determines if the device in question is a Nexus 4
	public void testOne() throws UiObjectNotFoundException {
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
	
	// This test determines whether the bluetooth toggle is on in the settings menu
	public void testTwo() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject settingsButton = new UiObject(new UiSelector().text("Settings"));
		settingsButton.clickAndWaitForNewWindow();
		
		UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
		settingsView.setAsVerticalList();
		UiObject bluetoothButton = settingsView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "Bluetooth");
		bluetoothButton.clickAndWaitForNewWindow();
		
	    UiObject toggleSwitch = new UiObject(new UiSelector().className("android.widget.Switch"));
	    assertTrue(toggleSwitch.getText().equals("ON"));
	}
	
	// This test should fail
	public void testThree() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject settingsButton = new UiObject(new UiSelector().text("Thistisntademocracy"));
		settingsButton.clickAndWaitForNewWindow();
		assertTrue(true);
	}
	
	// This test determines whether the mobile data is on in the Data usage menu
	public void testFour() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject settingsButton = new UiObject(new UiSelector().text("Settings"));
		settingsButton.clickAndWaitForNewWindow();
		
		UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
		settingsView.setAsVerticalList();
		UiObject dataButton = settingsView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), "Data usage");
		dataButton.clickAndWaitForNewWindow();
		
		UiObject dataToggle = new UiObject(new UiSelector().className("android.widget.Switch"));
		assertTrue(dataToggle.getText().equals("ON"));
	}
}
