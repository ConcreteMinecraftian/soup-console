package com.concreteminecraftian.console.variable;

import java.util.HashMap;

import com.concreteminecraftian.console.Command;
import com.concreteminecraftian.console.Console;

public class Var extends Command {
	
	public static HashMap<String, Variable> vars = new HashMap<>();
	
	public Var() { 
		super("var", "v");
		vars.put("e", new VariableNumber(Math.E));
		vars.put("pi", new VariableNumber(Math.PI));
	}

	@Override
	public void execute(String[] args) {
		
		boolean echo;
		try {
		
		switch(args[1]) {
		
		case "new":
			echo = true;
			if(args[4].contains("-s")) {
				System.out.print("Pick a variable for " + args[3] + "- ");
				args[4]=Console.sc.nextLine();
			}
			if(args.length > 5) {
				if(args[5].contains("-e")) echo = false;
			}
			switch(args[2]) {
			
			case "num":
				vars.put(args[3], new VariableNumber(Double.parseDouble(args[4])));
				if(echo) System.out.println("set new variable " + args[3] + " to " + args[4]);
				break;
			case "txt":
				vars.put(args[3], new VariableText(args[4].replace('_', ' ')));
				if(echo) System.out.println("set new variable " + args[3] + " to " + args[4]);
				break;
			case "bool":
				vars.put(args[3], new VariableBoolean(Boolean.parseBoolean(args[4].replace('_', ' '))));
				if(echo) System.out.println("set new variable " + args[3] + " to " + args[4]);
				break;
			
			}
			break;
		case "values":
			for(String key : vars.keySet()) {
				Variable var = vars.get(key);
				System.out.print(key + ": " + var.getDataInText() + ", ");
			}
			System.out.println();
			break;
		case "get":
			System.out.println(vars.get(args[2]).getDataInText());
			break;
		case "set":
			echo = true;
			for(String s : vars.keySet()) {
				if(s.equalsIgnoreCase(args[2])) {
					if(args[3].contains("-s")) {
						System.out.print("Pick a variable for " + args[2] + "- ");
						args[3]=Console.sc.nextLine();
					}
					if(args.length > 4) {
						if(args[4].contains("-e")) echo = false;
					}
					vars.get(s).setData(args[3]);
					if(echo) System.out.println("set variable " + s + " to " + args[3]);
				}
			}
		break;
		case "del":
			echo = true;
			if(args.length > 3) {
				if(args[3].contains("-e")) {
					echo = false;
				}
			}
			for(int i = 0; i < vars.keySet().size(); i++) {
				String s = (String)vars.keySet().toArray()[i];
				if(s.equalsIgnoreCase(args[2])) {
					vars.remove(s);
					if(echo) System.out.println("deleted variable " + s);
				}
			}
			break;
		default:
			System.out.println("==============================VARIABLE COMMANDS================================\n"+
							   "| v new <type(num/txt/bool)> <name> <value> |       makes a new variable      |\n"+
							   "|                 v values                  | prints out all variables stored |\n"+
							   "|               v get <name>                |       gets value from name      |\n"+
							   "===============================================================================");
			break;
		
		}
		
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("wrong syntax");
		} catch(NullPointerException e) {
			System.out.println("variable doesnt exist");
		}
		
	}
	
}
