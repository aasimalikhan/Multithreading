package org.example.BankingSystemSimulationChatGPTAssignment.code;

import java.util.Random;

public class RandomNumberStringGenerator {
    public static String generateRandomNumberString(int length)
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }
}
