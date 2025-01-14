package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class GeneralUtility {

public String getAttribute(WebElement element, String attribute ) {
		
		return element.getAttribute(attribute);
		
	}
	
	public String getCSSValue(WebElement element, String property)
	{
		return element.getCssValue(property);
	}
	
	public List<String> getTextOfElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element: elements) {
			
			data.add(element.getText());
		}
		return data;
	}
}
