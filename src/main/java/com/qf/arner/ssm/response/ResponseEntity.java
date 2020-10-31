package com.qf.arner.ssm.response;

import com.qf.arner.ssm.utils.ErrorStatus;
import lombok.Builder;
import lombok.Data;

/**
 * 包装以JSON数据结构返回前端的包装类
 * @param <T>
 */
@Data
@Builder
public class ResponseEntity<T> {
    private int status;
    private String message;
    private T data;

    public ResponseEntity(){}

    public ResponseEntity(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<T> success(T data){
        return ResponseEntity.<T>builder()
                .data(data)
                .message(ErrorStatus.SUCCESS.getMessage())
                .status(ErrorStatus.SUCCESS.getStatus())
                .build();
    }

    public static <T> ResponseEntity<T> error(){
        return ResponseEntity.<T>builder()
                .message(ErrorStatus.SYS_ERROR.getMessage())
                .status(ErrorStatus.SYS_ERROR.getStatus())
                .build();
    }

    public static <T> ResponseEntity<T> success(ErrorStatus errorStatus, T data) {
        return ResponseEntity
                .<T>builder()
                .data(data)
                .message(errorStatus.getMessage())
                .status(errorStatus.getStatus())
                .build();
    }

    public static <T> ResponseEntity<T> error(ErrorStatus errorStatus) {
        return ResponseEntity
                .<T>builder()
                .message(errorStatus.getMessage())
                .status(errorStatus.getStatus())
                .build();
    }
}
