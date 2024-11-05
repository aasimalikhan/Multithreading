package org.example.BankingSystemSimulationChatGPTAssignment.code.exception;

public class ServerErrorException extends RuntimeException{
    public ServerErrorException()
    {
        super("Something went wrong");
    }
}
