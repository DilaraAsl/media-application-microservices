package com.tsg.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    private final MessageSource messageSource;

    public WelcomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String helloInternationalized() {
        //Locale represents a users language and reigon preferences
        Locale locale = LocaleContextHolder.getLocale(); // retrieves the user's current locale

    // retrieves a message from a MessageSource object, which is typically configured with localized message resources for different languages
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}

