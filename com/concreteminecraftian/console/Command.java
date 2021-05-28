package com.concreteminecraftian.console;

public abstract class Command {
	
	public abstract void execute(String[] args);
	private String id;
	private String[] aliases;
	
	public String getId() {
		return id;
	}
	
	public String[] getAliases() {
		return aliases;
	}
	
	protected Command(String id, String...aliases) {
		this.id = id;
		this.aliases = aliases;
	}

}
