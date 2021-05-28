package com.concreteminecraftian.system;

import com.concreteminecraftian.console.module.Module;
import com.concreteminecraftian.system.commands.Echo;

public class SystemModule extends Module {

	@Override
	public void initCommands() { addCommands(new Echo()); }
	
	public SystemModule() {
		super("sys");
	}
	
}
