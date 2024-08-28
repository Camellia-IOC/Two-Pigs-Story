import {zoneService as service} from "@/api/AxiosRequestManager";

/**
 * 邀请用户共同开通空间
 * @param data 请求数据
 */
const inviteMate = (data: any) => {
    return service.post({
        url: '/api/zone/invite',
        data
    })
}

/**
 * 获取邀请信息列表
 * @param data 请求数据
 */
const getInvitationList = (data: any) => {
    return service.get({
        url: '/api/zone/invitations',
        data
    })
}

export default {
    inviteMate,
    getInvitationList
}