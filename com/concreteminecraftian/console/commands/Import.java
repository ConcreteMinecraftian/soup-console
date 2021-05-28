package com.concreteminecraftian.console.commands;

import com.concreteminecraftian.console.Command;
import com.concreteminecraftian.console.Console;
import com.concreteminecraftian.console.module.Module;

public class Import extends Command {

	public Import() {
		super("import","imp","i");
	}

	@Override
	public void execute(String[] args) {
		boolean echo = true;
		if(args.length > 2) if(args[2].contains("-e")) echo = false;
		try {
			Console.addModule(Module.fromID(args[1]));
			if(echo) System.out.println("imported module " + args[1]);
		} catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("module not found");
		}
	}

}
