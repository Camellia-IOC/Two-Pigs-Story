<template>
  <div class="container">
    <div v-if="hasZoneFlag==false" class="container">
      <h1>邀请好友</h1>
      <input>
      <a-button type="primary" @click="handleInviteRequest">邀请好友</a-button>
    </div>
    <div v-else>

    </div>
  </div>
</template>

<script setup lang="ts">
  import {onMounted, ref} from "vue";
  import {useRouter} from "vue-router";
  import zoneRequest from "@/api/modules/zoneApi"
  import {ElNotification} from "element-plus";

  const router = useRouter();

  // 是否拥有空间
  const hasZoneFlag = ref<boolean>(false);

  // 邀请信息列表
  const zoneInvitationList = ref([])

  const handleInviteRequest = async () => {
    await zoneRequest.inviteMate({senderId: 0, receiverId: 0})
                     .then((response: any) => {
                       ElNotification.success({
                         title: "提示",
                         message: "空间邀请发送成功！",
                         customClass: "notification-success"
                       })
                     })
                     .catch(() => {
                       ElNotification.error({
                         title: "请求失败",
                         message: "邀请发送失败，请稍后重新尝试",
                         customClass: "notification-error"
                       })
                     })
  }

  const getInvitationListRequest = async () => {
    await zoneRequest.getInvitationList({id: 1})
                     .then((response: any) => {
                       if (response.data.code == 200) {
                         zoneInvitationList.value = response.data.data.list;
                       }
                     })
                     .catch(() => {
                       ElNotification.error({
                         title: "请求失败",
                         message: "获取邀请信息列表失败，请稍后重新尝试",
                         customClass: "notification-error"
                       })
                     })
  }

  onMounted(() => {
    getInvitationListRequest();
  })
</script>

<style scoped lang="scss">
  .column-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .container {
    @extend .column-container;

    height: 90vh;
    gap: 2vh;
  }
</style>