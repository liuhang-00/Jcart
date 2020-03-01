var app = new Vue({
    el: '#app',
    data: {
        product:[],
        pageNum:1,
        pageSize:2,
        total:1,
        productVo:{},
        description:'<p><i>asdfa</i></p>'
    },methods: {
        search(){
            var params={
                pageNum:this.pageNum,
                productName:this.productVo.productName
            }
            axios.get("/product/search",{
                params:params
            }).then(res=>{
                this.product=res.data.list;
                this.pageNum=res.data.pageNum;
                this.pageSize=res.data.pageSize,
                this.total=res.data.total;
                console.log(this.product);
            })
        },
        currentchange(pageNum){
            this.pageNum=pageNum;
            this.search();
        }
        
    },mounted() {
        this.search();
    },
})