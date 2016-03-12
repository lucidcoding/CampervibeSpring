package uk.co.luciditysoftware.campervibe.site.viewmodels.common;

import java.util.UUID;

public class SelectListOption {
	private String text;
	private UUID value;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public UUID getValue() {
		return value;
	}
	
	public void setValue(UUID value) {
		this.value = value;
	}
}
