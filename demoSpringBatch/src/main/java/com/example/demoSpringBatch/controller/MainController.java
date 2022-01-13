package com.example.demoSpringBatch.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Tag(name="MainController", description="Контроллер отвечающий за ?")
@Controller
public class MainController { //localhost:8080/swagger-ui.html

    //@Operation(summary = "отправить ответ hello", description = "получаем запрос по /hello возвращаем hello и статус")
    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloMethod(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
