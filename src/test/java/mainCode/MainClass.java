package mainCode;

import org.junit.runner.JUnitCore;

//import bsh.This;
//import cucumber.api.junit.Cucumber;
import cucumberController.CucumberDriver;

public class MainClass {

	public static void main(String[] args){
		
		JUnitCore.runClasses(CucumberDriver.class);
	}
}
