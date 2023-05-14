package org.example;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class Main {
    public static void main(String[] args) {
        try (PowerShell powerShell = PowerShell.openSession()) {


            PowerShellResponse response;
            response = powerShell.executeCommand(" Add-Type -AssemblyName System.Speech;");
            System.out.println(response.getCommandOutput());
            response = powerShell.executeCommand("$speaker=New-Object System.Speech.Synthesis.SpeechSynthesizer;");
            System.out.println(response.getCommandOutput());
            response = powerShell.executeCommand("$speaker.speak('Hi Abhisek, I am Jarvis 2.0, your personal assistant');");
            System.out.println(response.getCommandOutput());
            response=powerShell.executeCommand("Exit;");
            System.out.println(response.getCommandOutput());
        } catch (PowerShellNotAvailableException e) {
            //todo: add what to do
            e.printStackTrace();
        }
    }
}