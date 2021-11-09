package com.demos.agora.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {
    // CMRespDto는 공통 응답 DTO를 의미한다.(common response dto)
    private int code;
    private T data;
}
