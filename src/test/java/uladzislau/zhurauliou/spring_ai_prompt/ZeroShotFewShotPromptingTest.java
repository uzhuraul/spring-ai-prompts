package uladzislau.zhurauliou.spring_ai_prompt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZeroShotFewShotPromptingTest extends OpenAITest {

    @Test
    @DisplayName("Zero Shot success")
    public void zeroShotSuccess(){
        String userMessage = """
                Text: I think the vacation is okay.
                """;
        String systemMessage = """
                Classify the text into neutral, negative or positive.
                """;
        String response = callClient(userMessage, systemMessage);

        System.out.println(response);
    }

    @Test
    @DisplayName("Zero Shot fail")
    public void zeroShotFail(){
        String userMessage = """
                Draft a job description for a software developer.
                """;

        String response = callClient(userMessage);

        System.out.println(response);
    }

    @Test
    @DisplayName("Few Shot success")
    public void fewShotSuccess(){
        String userMessage = """
                Draft a job description for a software developer..
                """;
        String systemMessage = """
                Include only this requirements.
                Requirement 1: 'We are looking for a full-stack developer with 3+ years of experience in JavaScript, React, and Node.js.
                 The ideal candidate should be able to handle both front-end and back-end tasks.'
                Requirement 2: 'The candidate must have experience with cloud services like AWS and a strong understanding of
                 microservices architecture.'
                """;
        String response = callClient(userMessage, systemMessage);

        System.out.println(response);
    }

}
