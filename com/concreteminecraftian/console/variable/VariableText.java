package com.concreteminecraftian.console.variable;

public class VariableText extends Variable {
	
	private String data;

	public String getData() {
		return data;
	}
	
	public VariableText(String data) {
		this.data = data;
	}

	@Override
	public String getDataInText() {
		return data;
	}
	
	@Override
	public void setData(String data) {
		this.data = data;
	}
	
}