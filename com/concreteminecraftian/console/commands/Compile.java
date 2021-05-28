package com.concreteminecraftian.console.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.concreteminecraftian.console.Command;
import com.concreteminecraftian.console.Console;

public class Compile extends Command {
	
	@Override
	public void execute(String[] args){
		
		if(args.length < 2) {
			System.out.println("error");
			System.out.println("usage- execute <path>");
			return;
		}
		File f = new File(args[1].replace('_', ' ')+ ".soup");
		try {
			BufferedReader read = new BufferedReader(new FileReader(f));
			String line;
			while((line = read.readLine()) != null) {
				Console.execute(line);
			}
			read.close();
		} catch (IOException e) {
			System.out.println("file not found");
		}
		
	}
	
	public Compile() {
		super("compile", "parse", "par", "exe", "exec", "execute");
	}
	
}
