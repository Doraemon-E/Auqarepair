package com.solidCore.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @projectName: AquaRepair
 * @package: com.solidCore.model.vo
 * @className: Result
 * @author: tongsheng
 * @description: TODO
 * @date: 2023/2/6 15:01
 * @version: 1.0
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result {

    private Integer code;
    private String message;
    private Object data;

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ok(String message){
        return new Result(200, message);
    }

    public static Result ok(String message, Object data){
        return new Result(200, message, data);
    }

    public static Result error(String message){
        return new Result(500, message);
    }

    public static Result error(String message, Object data){
        return new Result(500, message, data);
    }

    public static Result create(Integer code, String message){
        return new Result(code, message);
    }

    public static Result create(Integer code, String message, Object data){
        return new Result(code, message, data);
    }


}
