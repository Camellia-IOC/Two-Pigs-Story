import BaseAxiosInstance from "@/api/BaseAxiosInstance";

// 服务器IP
/** 服务器IP */
const serverIP: string = '127.0.0.1';

// 微服务端口
/** 认证服务端口 */
const authServicePort: string = '8081';
/** 用户服务端口 */
const userServicePort: string = '8082';
/** 空间服务端口 */
const zoneServicePort: string = '8083';
/** 社交服务端口 */
const socialServicePort: string = '8084';

// 生成并导出axios实例
/** 认证服务实例 */
export const authenticationService = new BaseAxiosInstance(serverIP, authServicePort, 10000);
/** 用户服务实例 */
export const userService = new BaseAxiosInstance(serverIP, userServicePort, 10000);
/** 空间服务实例 */
export const zoneService = new BaseAxiosInstance(serverIP, zoneServicePort, 10000);
/** 社交服务实例 */
export const socialService = new BaseAxiosInstance(serverIP, socialServicePort, 10000);
