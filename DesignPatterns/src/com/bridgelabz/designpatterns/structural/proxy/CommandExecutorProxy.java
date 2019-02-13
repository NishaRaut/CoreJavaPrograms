package com.bridgelabz.designpatterns.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private CommandExecutor executor;
	private boolean isAdmin;

	public CommandExecutorProxy(String username, String password) {
		executor = new CommandExecutorImpl();
		if ("Admin".equals(username) && "admin123".equals(password))
			isAdmin = true;
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);//execute without any restrictions
		} else {
			if (cmd.trim().startsWith("rm"))//restricting the deleting stuffs for non-admin user 
				throw new Exception("Delete cmd not allowed for non admin user ..!!");
			else
				executor.runCommand(cmd);
		}
	}
}
