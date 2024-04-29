package com.example.filter.controller;

import com.example.filter.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    @PostMapping("")
    public void register(@RequestBody UserRequest userRequest){
        log.info("{}", userRequest);
    }
}
