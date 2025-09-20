package com.yupi.aicodehelper.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

// Springboot 为 @AiService 生成代理对象
//@AiService
public interface AiCodeHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
//    String chat(@MemoryId int memoryId, String userMessage);
}
