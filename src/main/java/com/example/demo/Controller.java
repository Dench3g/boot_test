package com.example.demo;

import com.example.demo.api.PolygonInfo;
import com.example.demo.api.Rectangle;
import com.example.demo.validation.ValidRectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
public class Controller {

    private static Logger LOG = LoggerFactory.getLogger(Controller.class);

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

    @PostMapping(value = "pol_info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PolygonInfo pol_info(@RequestBody @Valid Rectangle rectangle) {
        LOG.trace("{}", rectangle);
        PolygonInfo polygonInfo = new PolygonInfo();
        polygonInfo.setArea(rectangle.getA() * rectangle.getB());
        polygonInfo.setPerimeter(2 * (rectangle.getA() + rectangle.getB()));
        return polygonInfo;
    }

    @ExceptionHandler({MyException.class})
    public @ResponseBody MyEntity handleException(MyException exception) {
        MyEntity myEntity = new MyEntity();
        myEntity.setKey("ERROR KEY!: " + exception.getKey());
        myEntity.setUuid("8888");
        return myEntity;
    }

}
