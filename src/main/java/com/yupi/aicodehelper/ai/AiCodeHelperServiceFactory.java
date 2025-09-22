package com.yupi.aicodehelper.ai;

import com.yupi.aicodehelper.ai.tools.InterviewQuestionTool;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {

    @Resource
//    private ChatModel qwenChatModel;
    private ChatModel myQwenChatModel;


    @Resource
    private ContentRetriever contentRetriever;

    @Resource
    private McpToolProvider mcpToolProvider;

    // 创建 AI Service 实现类
    // 背后原理是 JAVA 反射机制创建了一个实现接口的代理对象
    @Bean
    public AiCodeHelperService aiCodeHelperService() {
        // 会话记忆
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        // 创建 AI Service
        AiCodeHelperService aiCodeHelperService = AiServices.builder(AiCodeHelperService.class)
                .chatModel(myQwenChatModel)
                .chatMemory(chatMemory)
//                不同用户会话记录隔离
//                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                // RAG 内容检索生成
                .contentRetriever(contentRetriever)
                // 工具调用
                .tools(new InterviewQuestionTool())
                // MCP 工具调用
                .toolProvider(mcpToolProvider)
                .build();
        return aiCodeHelperService;
    }
}
