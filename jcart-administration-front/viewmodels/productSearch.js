var app = new Vue({
    el: '#app',
    data: {
        pageNum:1,
        pageSize:2,
        total:1,
        product:[],
        productVo:{},
        statusList:[
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ]
    },
    methods: {
        search(){
            console.log(this.productVo.status);
            var params={
                pageNum:this.pageNum,
                productName:this.productVo.productName,
                productCode:this.productVo.productCode,
                price:this.productVo.price,
                status:this.productVo.status,
                stockQuantity:this.productVo.stockQuantity          
            };
            axios.get("/product/search",{params:params}).then(res=>{
                this.pageNum=res.data.pageNum;
                this.pageSize=res.data.pageSize;
                this.total=res.data.total;
                this.product=res.data.list;
                console.log(res.data)
            })
        },
        currentchange(pageNum){
            this.pageNum=pageNum;
            this.search();
        }
    },
    mounted() {
        this.search();
    },
})