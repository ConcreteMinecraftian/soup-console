package com.concreteminecraftian.console.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.concreteminecraftian.console.Command;
import com.concreteminecraftian.system.SystemModule;

public abstract class Module {

	public Module(String id) {
		this.id = id;
		initCommands();
	}
	
	private List<Command> commands = new ArrayList<>();
	private String id;
	public static ArrayList<Module> modules = new ArrayList<Module>();
	
	public static void registerModule(Module module) {
		modules.add(module);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Command> commands() {
		return commands;
	}
	
	protected void addCommand(Command command) {
		commands.add(command);
	}
	
	protected void addCommands(Command...commands) {
		this.commands.addAll(Arrays.asList(commands));
	}
	
	public abstract void initCommands();
	
	public static Module fromID(String id) {
		for(Module m : modules) {
			if(m.getId().equalsIgnoreCase(id)) return m;
		}
		return null;
	}

	public static void registerModules() {
		
		registerModule(new SystemModule());
		
	}
	
}
