package org.example.BankingSystemSimulationChatGPTAssignment.code.exception;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException()
    {
        super("Unable to transfer - Insufficient funds");
    }
}
