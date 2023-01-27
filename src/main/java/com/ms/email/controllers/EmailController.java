package com.ms.email.controllers;


import com.ms.email.DTOs.EmailDTO;
import com.ms.email.models.EmailModel;
import com.ms.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){

        EmailModel email = new EmailModel();
        BeanUtils.copyProperties(emailDTO,email);
        emailService.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);

    }

}
