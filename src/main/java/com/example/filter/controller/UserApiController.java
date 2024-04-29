package com.example.filter.controller;

import com.example.filter.model.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

   /* 디버깅 임시로 찍어보는 방법
    @PostMapping("")
    public void register( HttpEntity http){
        log.info("{}",http.getBody() );
    }*/

   /* echo로 내리는 방법. 실질적으로 어떻게 정확하게 내려갔는지 알 방법이 없다
   @PostMapping("")
    public UserRequest register(@RequestBody UserRequest userRequest){
        log.info("{}",userRequest );
        return userRequest;
    }*/
}
