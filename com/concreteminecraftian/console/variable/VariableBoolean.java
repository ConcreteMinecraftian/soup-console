package com.concreteminecraftian.console.variable;

public class VariableBoolean extends Variable {
	
	private boolean data;

	public boolean getData() {
		return data;
	}

	public void setData(boolean data) {
		this.data = data;
	}
	
	public VariableBoolean(boolean data) {
		this.data = data;
	}

	@Override
	public String getDataInText() {
		return Boolean.toString(data);
	}

	@Override
	public void setData(String string) {
		this.data = Boolean.parseBoolean(string);
	}
	
}
