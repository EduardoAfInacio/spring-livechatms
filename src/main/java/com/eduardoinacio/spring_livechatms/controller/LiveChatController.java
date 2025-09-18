package com.eduardoinacio.spring_livechatms.controller;

import com.eduardoinacio.spring_livechatms.domain.ChatInput;
import com.eduardoinacio.spring_livechatms.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {
    @MessageMapping("/new-message")
    @SendTo("/topic/livechat")
    public ChatOutput newMessage(ChatInput chatInput) {
        String message = HtmlUtils.htmlEscape(chatInput.user() + ": " + chatInput.message());
        return new ChatOutput(message);
    }
}
