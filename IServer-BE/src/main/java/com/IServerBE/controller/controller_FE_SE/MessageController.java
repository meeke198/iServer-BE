package com.IServerBE.controller.controller_FE_SE;

import com.IServerBE.service.impl.MessageServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class MessageController {
    private final MessageServiceImpl messageService;
}
