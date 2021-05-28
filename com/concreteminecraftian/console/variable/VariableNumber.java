package com.concreteminecraftian.console.variable;

public class VariableNumber extends Variable {
	
	private double data;

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}
	
	public VariableNumber(double data) {
		this.data = data;
	}

	@Override
	public String getDataInText() {
		return Double.toString(data);
	}

	@Override
	public void setData(String string) {
		this.data = Double.parseDouble(string);
	}
	
}
