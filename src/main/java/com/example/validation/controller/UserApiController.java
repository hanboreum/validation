package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    //가입
    @PostMapping("")
    public Api<UserRegisterRequest> register( //요청 할 때도 Api스펙을 통해 리턴.
            @Valid //검증
            @RequestBody Api<UserRegisterRequest> user){ //요청도 Api스펙으로 요청
        //이제 서버는 항상Api라는 스펙을 통해서만 제이슨을 보낼 수 있음
        log.info("userRequest : {}", user);


        var body = user.getData();
        Api<UserRegisterRequest> response = Api.<UserRegisterRequest>builder()
                .data(body)
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .build();
        //빌더 통해 해당 데이터 빌드, response응답 내림
        return response;
    }
}
