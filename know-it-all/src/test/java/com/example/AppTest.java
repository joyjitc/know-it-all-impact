package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import picocli.CommandLine;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class AppTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testWhoAmICommand() {
        String[] args = {"who-am-i"};
        new CommandLine(new App()).execute(args);
        
        String output = outContent.toString();
        assertTrue("Output should contain 'com.impact.saasquatch'", 
                   output.contains("com.impact.saasquatch"));
    }

    @Test
    public void testWhatShouldIDoCommand() {
        String[] args = {"what-should-i-do"};
        new CommandLine(new App()).execute(args);
        
        String output = outContent.toString();
        assertTrue("Output should contain 'Joyjit'", 
                   output.contains("Joyjit"));
        assertTrue("Output should contain 'jaysea.org'", 
                   output.contains("jaysea.org"));
    }

    @Test
    public void testHelpOption() {
        String[] args = {"--help"};
        new CommandLine(new App()).execute(args);
        
        String output = outContent.toString();
        assertTrue("Help should show app name", 
                   output.contains("know-it-all"));
        assertTrue("Help should show who-am-i command", 
                   output.contains("who-am-i"));
        assertTrue("Help should show what-should-i-do command", 
                   output.contains("what-should-i-do"));
    }

    @Test
    public void testVersionOption() {
        String[] args = {"--version"};
        new CommandLine(new App()).execute(args);
        
        String output = outContent.toString();
        assertTrue("Version output should contain version number", 
                   output.contains("1.0"));
    }

    @Test
    public void testNoArgsShowsHelpMessage() {
        String[] args = {};
        new CommandLine(new App()).execute(args);
        
        String output = outContent.toString();
        assertTrue("Should show help message when no args provided", 
                   output.contains("Use --help to see available commands"));
    }
}