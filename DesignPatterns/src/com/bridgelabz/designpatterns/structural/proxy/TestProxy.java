package com.bridgelabz.designpatterns.structural.proxy;

public class TestProxy {

	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("Admin", "admin123");
		try {
			executor.runCommand("ls -l");
			executor.runCommand("rm -f C:resource\temp.txt");
		} catch (Exception e) {
			System.out.println("Excetion " + e.getMessage());
		}
	}
}
