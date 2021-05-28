package com.concreteminecraftian.console.commands;

import com.concreteminecraftian.console.Command;
import com.concreteminecraftian.console.variable.Var;
import com.concreteminecraftian.console.variable.VariableNumber;

public class Operation extends Command {

	@Override
	public void execute(String[] args) {
		if(args.length < 3) {
			System.out.println("error");
			System.out.println("usage- operation <operation> <args 1> [args 2]");
			return;
		}
		try {
			boolean echo = true;
			double result = 0.0;
			switch(args[1]) {
			
			//Double Argument
			case "add":
				result = Double.parseDouble(args[2]) + Double.parseDouble(args[3]);
				break;
			case "subtract":
				result = Double.parseDouble(args[2]) - Double.parseDouble(args[3]);
				break;
			case "multiply":
				result = Double.parseDouble(args[2]) * Double.parseDouble(args[3]);
				break;
			case "divide":
				result = Double.parseDouble(args[2]) / Double.parseDouble(args[3]);
				break;
			case "mod":
				result = Double.parseDouble(args[2]) % Double.parseDouble(args[3]);
				break;
			case "exp":
				result = Math.pow(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
				break;
			//Single Argument
			case "sin":
				result = Math.sin(Double.parseDouble(args[2]));
				break;
			case "cos":
				result = Math.cos(Double.parseDouble(args[2]));
				break;
			case "tan":
				result = Math.tan(Double.parseDouble(args[2]));
				break;
			case "asin":
				result = Math.asin(Double.parseDouble(args[2]));
				break;
			case "acos":
				result = Math.acos(Double.parseDouble(args[2]));
				break;
			case "atan":
				result = Math.atan(Double.parseDouble(args[2]));
				break;
			case "ceil":
				result = Math.ceil(Double.parseDouble(args[2]));
				break;
			case "flr":
				result = Math.floor(Double.parseDouble(args[2]));
				break;
			case "round":
				result = Math.round(Double.parseDouble(args[2]));
				break;
			default: 
				System.out.println("error");
				System.out.println("usage- operation <operation> <args 1> [args 2]");
				break;
				
			}
			if(args.length > 4) {
				if(args[4].contains("-v")) {
					Var.vars.put("result", new VariableNumber(result));
					echo = false;
				}
			}
			if(echo) System.out.println(result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Missing argument 2 for double argument expression");
		} catch(NumberFormatException e) {
			System.out.println("Please enter Double argument for operations!");
		}
		
	}
	
	public Operation() { super("operation", "oper", "calc", "calculate", "math"); }

}
