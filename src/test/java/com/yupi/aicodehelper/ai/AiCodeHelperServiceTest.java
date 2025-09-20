package com.yupi.aicodehelper.ai;

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
}