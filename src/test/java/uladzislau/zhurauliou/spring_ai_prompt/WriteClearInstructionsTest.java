package uladzislau.zhurauliou.spring_ai_prompt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WriteClearInstructionsTest extends OpenAITest {

    @Test
    @DisplayName("Include details in your query to get more relevant answers")
    public void includeDetailsInQueryToGetMoreRelevantAnswers(){
        String requestWithoutDetails = "Who’s president?";
        String response1 = callClient(requestWithoutDetails);
        String requestWithDetails = "Who was the president of Mexico in 2024, and how frequently are elections held?";
        String response2 = callClient(requestWithDetails);

        System.out.println(response1);
        System.out.println("-------------------------");
        System.out.println(response2);
    }

    @Test
    @DisplayName("Ask the model to adopt a persona")
    public void askTheModelToAdoptThePersona(){
        String requestWithoutDetails = "Tell me who are you?";
        String response1 = callClient(requestWithoutDetails);
        String systemMessage = "Respond as if you're a friendly customer service representative";
        String response2 = callClient(requestWithoutDetails, systemMessage);

        System.out.println(response1);
        System.out.println("-------------------------");
        System.out.println(response2);
    }

    @Test
    @DisplayName("Use delimiters to clearly indicate distinct parts of the input")
    public void useDelimitersToClearlyIndicateDistinctPartsOfTheInput(){
        String request = """
                <actor>Tom Hanks</actor>
                <films type="array">
                    <value>Forrest Gump</value>
                    <value>Philadelphia</value>
                </films>
                """;
        String systemMessage = """
                You will be provided with list of films and actor (delimited with XML tags).
                You need to answer whether the actor starred in these films or not.
                """;
        String response = callClient(request, systemMessage);

        System.out.println(response);
    }

    @Test
    @DisplayName("Specify the steps required to complete a task")
    public void specifyTheStepsRequiredToCompleteATask() {
        String request = """
                Spring AI is a framework designed to integrate artificial intelligence (AI) capabilities,
                such as those provided by OpenAI, into Java-based applications built with the Spring framework.
                It simplifies the process of adding AI-driven features like natural language processing,
                chatbots, and automated decision-making to your Spring applications. By leveraging Spring AI,
                developers can easily incorporate powerful AI models into their software, enhancing functionality
                and user experience without needing deep expertise in AI.
                """;
        String systemMessage = """
                Use the following step-by-step instructions to respond to user inputs.
                
                Step 1 - The user will provide you with text.
                Summarize this text in one sentence with a prefix that says "Summary: ".
                
                Step 2 - Translate the summary from Step 1 into Spanish, with a prefix that says "Translation: ".
                """;
        String response = callClient(request, systemMessage);

        System.out.println(response);
    }

    @Test
    @DisplayName("Provide examples")
    public void provideExamples() {
        String request = """
                AI-powered smartphone
                """;
        String systemMessage = """
                Generate a headline for a tech news article. For reference, here are a few examples:
                                
                "Apple Unveils Revolutionary New MacBook Pro with M3 Chip"
                "Google Announces Major Update to Android Operating System"
                "Tesla’s Latest Software Update Brings Full Self-Driving Capabilities to All Models"
                """;

        String response = callClient(request, systemMessage);

        System.out.println(response);
    }

    @Test
    @DisplayName("Specify the desired length of the output")
    public void specifyTheDesiredLengthOfTheOutput() {
        String request = """
                Spring AI is a framework designed to integrate artificial intelligence (AI) capabilities,
                such as those provided by OpenAI, into Java-based applications built with the Spring framework.
                It simplifies the process of adding AI-driven features like natural language processing,
                chatbots, and automated decision-making to your Spring applications. By leveraging Spring AI,
                developers can easily incorporate powerful AI models into their software, enhancing functionality
                and user experience without needing deep expertise in AI.
                """;
        String systemMessage = """
                Summarize the text about SpringAI in 5 words.
                """;

        String response = callClient(request, systemMessage);

        System.out.println(response);
    }

}
