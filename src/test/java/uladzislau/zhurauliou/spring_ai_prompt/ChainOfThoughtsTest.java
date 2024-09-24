package uladzislau.zhurauliou.spring_ai_prompt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChainOfThoughtsTest extends OpenAITest {

    @Test
    @DisplayName("Standard prompt fails")
    public void standardPromptFails() {
        for (int i = 0; i < 10; i++) {
            String userMessage = """
                    The odd numbers in this group add up to an even number: 4, 8, 9, 15, 12, 2, 1.
                    A: The answer is False.
                    The odd numbers in this group add up to an even number: 17,  10, 19, 4, 8, 12, 24.
                    A: The answer is True.
                    The odd numbers in this group add up to an even number: 16,  11, 14, 4, 8, 13, 24.
                    A: The answer is True.
                    The odd numbers in this group add up to an even number: 17,  9, 10, 12, 13, 4, 2.
                    A: The answer is False.
                    The odd numbers in this group add up to an even number: 15, 32, 5, 13, 82, 7, 1.
                    A:
                    """;
            String response = callClient(userMessage);
            System.out.println(response);
        }
    }

    @Test
    @DisplayName("Chain of thoughts prompt success")
    public void chainOfThoughtsPromptSuccess() {
        for (int i = 0; i < 10; i++) {
            String userMessage = """
                    The odd numbers in this group add up to an even number: 4, 8, 9, 15, 12, 2, 1.
                    A: Adding all the odd numbers (9, 15, 1) gives 25. The answer is False.
                    
                    The odd numbers in this group add up to an even number: 17,  10, 19, 4, 8, 12, 24.
                    A: Adding all the odd numbers (17, 19) gives 36. The answer is True.
                   
                    The odd numbers in this group add up to an even number: 16,  11, 14, 4, 8, 13, 24.
                    A: Adding all the odd numbers (11, 13) gives 24. The answer is True.
                   
                    The odd numbers in this group add up to an even number: 17,  9, 10, 12, 13, 4, 2.
                    A: Adding all the odd numbers (17, 9, 13) gives 39. The answer is False.
                  
                    The odd numbers in this group add up to an even number: 15, 32, 5, 13, 82, 7, 1.
                    A:
                    """;
            String response = callClient(userMessage);
            System.out.println(response);
        }
    }

}
