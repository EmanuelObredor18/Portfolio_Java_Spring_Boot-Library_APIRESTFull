package com.obredor.library.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void testMessageSource() {
        //String actualMessage = messageSource.getMessage("validation.required.field", null, Local);
        // System.out.println(actualMessage);
        // assertEquals("Este campo es requerido. Por favor, agregue una entrada.", actualMessage);
    }
}
