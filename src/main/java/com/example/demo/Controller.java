package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
public class Controller {

    @Inject
    private MyService myService;

    @GetMapping("/get/{key}")
    public String getUuid(@PathVariable String key) throws MyException {
        return myService.getUUID(key);
    }

    @GetMapping(value = "gete/{key}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MyEntity getEntity(@PathVariable String key) throws MyException {
        String uuid = myService.getUUID(key);
        MyEntity myEntity = new MyEntity();
        myEntity.setKey(key);
        myEntity.setUuid(uuid);
        return myEntity;
    }

    @ExceptionHandler({MyException.class})
    public @ResponseBody MyEntity handleException(MyException exception) {
        MyEntity myEntity = new MyEntity();
        myEntity.setKey("ERROR KEY!: " + exception.getKey());
        myEntity.setUuid("8888");
        return myEntity;
    }

}
