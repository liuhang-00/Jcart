var app = new Vue({
    el: '#app',
    data: {
        pageNum:1,
        pageSize:2,
        total:1,
        product:[],
        productName:'',
        productCode:'',
        price:0.00,
        status:0,
        stockQuantity:0
    },
    methods: {
        search(){
            console.log(this.status);
            var params={
                pageNum:this.pageNum,
                productName:this.productName,
                productCode:this.productCode,
                price:this.price,
                status:this.status,
                stockQuantity:this.stockQuantity          
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