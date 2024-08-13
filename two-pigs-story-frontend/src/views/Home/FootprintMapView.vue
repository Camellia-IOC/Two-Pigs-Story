<template>
    <div class="china-map" ref="chinaMapRef"></div>
</template>

<script lang="ts" setup>
    import { ref, onMounted } from 'vue'
    import { useRouter } from 'vue-router'
    import * as echarts from "echarts";
    import china from '@/assets/resources/map/json/china.json'

    const router = useRouter()

    const chinaMapRef = ref();

    // 图片对象类型
    interface imageItem {
        id: number,
        url: string,
        date: string,
        location: string,
    }

    // 当前图片列表
    const imageList = ref<Array<imageItem>>([])

    // 数据对象类型
    interface mapItem {
        name: string,
        value: number,
        selected: boolean,
    }

    // 数据集
    const dataSet = ref<Map<string, mapItem>>();
    dataSet.value = new Map<string, mapItem>();
    dataSet.value.set("福建省", { name: "福建省", value: 100, selected: true });
    dataSet.value.set("江西省", { name: "江西省", value: 120, selected: true });

    const chinaMapInit = (item: any) => {
        if (!chinaMapRef.value) {
            return;
        }

        echarts.registerMap("china", item);
        const chinaMapChart = echarts.init(chinaMapRef.value);

        /** @type EChartsOption */
        const option = {
            title: {
                text: "",
            },
            tooltip: {},
            series: [
                {
                    name: '中国地图',
                    type: 'map',
                    map: 'china',
                    label: {
                        show: true
                    },
                    data: dataSet.value,
                    selectedMode: 'multiple',

                    // 图表样式
                    itemStyle: {
                        areaColor: '#eee',
                    },
                    emphasis: {
                        itemStyle: {
                            areaColor: 'lightblue',
                        },
                    },
                    select: {
                        itemStyle: {
                            color: 'pink',
                            borderColor: 'red',
                        },
                    },
                },

            ],
        };

        chinaMapChart.setOption(option);
        chinaMapChart.on('click', (params) => {
            alert(params.name + ' ' + params.value + ' ' + params.selected);
            // if (dataSet.value.get(params.name).selected != true) {
            chinaMapChart.dispatchAction({
                type: 'unselect',
                seriesIndex: params.seriesIndex, // 系列的索引
                dataIndex: params.dataIndex // 数据项的索引
            });
            // }
        });
    }

    onMounted(() => {
        chinaMapInit(china);
    })

</script>

<style lang="scss" scoped>
    .column-container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .china-map {
        @extend .column-container;

        width: 100vw;
        height: 80vw;
    }
</style>