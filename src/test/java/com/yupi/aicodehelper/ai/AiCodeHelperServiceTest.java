package com.yupi.aicodehelper.ai;

import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeHelperServiceTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        String result = aiCodeHelperService.chat("讲解 3D 接雨水的算法思路");
        System.out.println(result);
    }

    @Test
    void chatWithMemory() {
        String result = aiCodeHelperService.chat("你好，我是 Octaver。");
        System.out.println(result);
        result = aiCodeHelperService.chat("猜猜我是谁？");
        System.out.println(result);
    }

    @Test
    void chatForReport() {
        String userMassage = "你好，我是 Octaver，今年大三，请帮我定制福州大学 085404 上岸计划";
        AiCodeHelperService.Report report = aiCodeHelperService.chatForReport(userMassage);
        System.out.println(report);
    }

    @Test
    void chatWithRag() {
        Result<String> result = aiCodeHelperService.chatWithRag("怎么备考 408？有哪些推荐的院校？");
        System.out.println(result.sources());
        System.out.println(result.content());
    }

    @Test
    void chatWithTools() {
        String result = aiCodeHelperService.chat("有哪些常见的 spring 面试题？");
        System.out.println(result);
    }

    @Test
    void chatWithMCP() {
        String result = aiCodeHelperService.chat("今天的 B 站每周必看有哪些？");
        System.out.println(result);
    }

    @Test
    void chatWithGuardrail() {
//        String result = aiCodeHelperService.chat("kill kiss 的歌手是谁？");
        String result = aiCodeHelperService.chat("蔡徐坤的 Dead man 相关信息");
        System.out.println(result);
    }
}