package org.demo.TwoPigsStoryBackend.entity;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    /**
     * 标准正确状态码
     */
    SUCCESS(200, "success"),
    
    /**
     * 登录注册模块：1xx
     */
    LOGIN_FAILED_ERROR(100, "登录时发生错误，请重新尝试"),
    REGISTER_FAILED_ERROR(101, "注册时发生错误，请重新尝试"),
    
    /**
     * 用户模块：3xx
     */
    USER_NOT_LOGIN(300, "用户未登录"),
    USER_ACCOUNT_LOGIN_OTHERS(301, "用户账号在其他地方登录"),
    
    /**
     * 空间模块：4xx
     */
    INVITE_FAILED_ERROR(400, "邀请失败，请重新尝试"),
    INVITATION_HAS_BEEN_HANDLED(401, "该邀请已经处理完毕，请勿重复处理"),
    INVITATION_HANDLE_FAILED_ERROR(402, "邀请处理失败，请重新尝试"),
    ZONE_CREATE_FAILED_ERROR(403, "空间创建失败，请重新尝试"),
    ZONE_CLOSE_FAILED_ERROR(404, "空间关闭失败，请重新尝试"),
    ZONE_CONFIGURE_FAILED_ERROR(405, "空间配置失败，请重新尝试");
    
    private final int code;
    
    private final String msg;
    
    ResponseStatus (int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
