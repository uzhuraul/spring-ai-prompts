package uladzislau.zhurauliou.spring_ai_prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAITest {

    @Autowired
    protected ChatModel chatModel;

    protected String callClient(String message) {
        var client = ChatClient.builder(chatModel)
                .defaultOptions(OpenAiChatOptions.builder()
                        .withModel(OpenAiApi.ChatModel.GPT_4_O)
                        .build())
                .build();
        return client.prompt()
                .user(message)
                .call()
                .content();
    }

    protected String callClient(String userMessage, String systemMessage) {
        var client = ChatClient.create(chatModel);
        return client.prompt()
                .user(userMessage)
                .system(systemMessage)
                .call()
                .content();
    }

}
