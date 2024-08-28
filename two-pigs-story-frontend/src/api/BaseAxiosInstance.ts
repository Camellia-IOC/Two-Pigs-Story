import axios from "axios";
import type { AxiosInstance } from "axios";
import type { AxiosRequestConfig } from "axios";
import { ElMessage } from "element-plus";

// 基础axios实例
class BaseAxiosInstance {
    /** axios实例 */
    public instance: AxiosInstance;

    /**
     * 构造axios实例
     *
     * @param serverIP 服务器IP
     * @param servicePort 服务端口
     * @param timeout 超时时间
     */
    constructor(serverIP: string, servicePort: string, timeout: number) {
        this.instance = axios.create({
            baseURL: `http://${serverIP}:${servicePort}`,
            timeout: timeout
        });

        // 配置请求拦截器
        this.instance.interceptors.request.use(
            (config) => {
                // 请求预处理
                config.headers = config.headers || {}
                return config
            },
            (error) => {
                // 错误处理
                return Promise.reject(error)
            }
        );

        // 配置响应拦截器
        this.instance.interceptors.response.use(
            (response) => {
                // 响应数据预处理
                return response
            },
            (error) => {
                // TODO: 发布时要删除以下代码
                // 错误处理
                if (error.response) {
                    ElMessage({
                        message: error.response.data.status + ' ' + error.response.data.error,
                        type: 'error',
                        duration: 5 * 1000
                    })
                }
                return Promise.reject(error)
            }
        );

    }

    /** get请求 */
    public get = (config: AxiosRequestConfig<any>) => {
        return this.instance({
            ...config,
            method: 'get',
            params: config.data
        })
    }

    /** post请求 */
    public post = (config: AxiosRequestConfig<any>) => {
        return this.instance({
            ...config,
            method: 'post',
            data: config.data
        })
    }

    /** put请求 */
    public put = (config: AxiosRequestConfig<any>) => {
        return this.instance({
            ...config,
            method: 'put',
            data: config.data
        })
    }

    /** delete请求 */
    public delete = (config: AxiosRequestConfig<any>) => {
        return this.instance({
            ...config,
            method: 'delete',
            data: config.data
        })
    }
}

export default BaseAxiosInstance;