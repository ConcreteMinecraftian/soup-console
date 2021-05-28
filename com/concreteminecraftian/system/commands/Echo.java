package com.concreteminecraftian.system.commands;

import com.concreteminecraftian.console.Command;

public class Echo extends Command {

	public Echo() {
		super("echo", "print", "out");
	}

	@Override
	public void execute(String[] args) {
		try {
			System.out.println(args[1].replace("_", " "));
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("");
		}
	}
	
}
