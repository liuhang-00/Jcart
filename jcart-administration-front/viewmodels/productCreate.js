var app = new Vue({
    el: '#app',
    data: {
        productVo:{},
        statusList:[
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ]
    },methods: {
        onsubmit(){

        }
    },mounted() {
        
    },
})