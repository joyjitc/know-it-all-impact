package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "know-it-all", 
         mixinStandardHelpOptions = true,
         version = "1.0",
         description = "An app that might get me hired",
         subcommands = {WhoAmI.class, WhatShouldIDo.class})
public class App implements Runnable {
    
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    
    @Override
    public void run() {
        System.out.println("Use --help to see available commands");
    }
}

@Command(name = "who-am-i",
         description = "Tells you who you are!")
class WhoAmI implements Runnable {
    
    @Override
    public void run() {
        System.out.println("You are com.impact.saasquatch!");
    }
}

@Command(name = "what-should-i-do",
         description = "Provides guidance on what to do.")
class WhatShouldIDo implements Runnable {
    
    @Override
    public void run() {
        String website = "\u001B]8;;https://jaysea.org\u001B\\jaysea.org\u001B]8;;\u001B\\";
        System.out.println("You should hire Joyjit\nFor more info visit " + website);
    }
}