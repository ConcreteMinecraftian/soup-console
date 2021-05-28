package com.concreteminecraftian.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.concreteminecraftian.console.commands.Compile;
import com.concreteminecraftian.console.commands.Import;
import com.concreteminecraftian.console.commands.Operation;
import com.concreteminecraftian.console.commands.Read;
import com.concreteminecraftian.console.module.Module;
import com.concreteminecraftian.console.variable.Var;

public class Console {
	
	public static Scanner sc = new Scanner(System.in);
	private static List<Command> commands = new ArrayList<>();
	private static String[] args;
	
	public static void main(String[] argv) {
		
		commands.addAll(Arrays.asList(new Command[] {
			new Operation(), new Compile(), new Read(), new Var(), new Import()
		}));
		
		Module.registerModules();
		boolean exit = false;
		while(!exit) {
			String command = sc.nextLine();
			for(String key : Var.vars.keySet()) {
				if(command.contains("%"+key+"%")) {
					command = command.replace("%"+key+"%", Var.vars.get(key).getDataInText());
				}
			}
			args = command.split(" ");
			String label = args[0];
			
			if(label.equalsIgnoreCase("exit")) {
				exit = true;
			}
			for(int i = 0; i < commands.size(); i++) {
				Command c = commands.get(i);
				if(label.equalsIgnoreCase(c.getId()))
					c.execute(args);
				for(String alias : c.getAliases()) {
					if(label.equalsIgnoreCase(alias))
						c.execute(args);
				}
			}
			
		}
		sc.close();
		
	}
	
	public static void start() { main(new String[] {}); }
	
	public static boolean execute(String line) {
		for(String key : Var.vars.keySet()) {
			if(line.contains("%"+key+"%")) {
				line = line.replace("%"+key+"%", Var.vars.get(key).getDataInText());
			}
		}
		args = line.split(" ");
		String label = args[0];
		
		for(int i = 0; i < commands.size(); i++) {
			Command c = commands.get(i);
			if(label.equalsIgnoreCase(c.getId()))
				c.execute(args);
			for(String alias : c.getAliases()) {
				if(label.equalsIgnoreCase(alias))
					c.execute(args);
			}
		}
		return true;
	}
	
	public static void addModule(Module module) {
		for(Command c : module.commands()) {
			commands.add(c);
		}
	}

}