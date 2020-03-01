var app = new Vue({
    el: '#app',
    data: {
        product:{},
        otherPicUrls:'',
        mainPicUrl:'',
        productName:'',
        price:'',
        discount:0.1,
        stockQuantity:200,
       productId:0,
        description:'<p><i>asdfa</i></p>'
    },methods: {
        getProduct(){
            console.log(this.productId)
            var params={
                productId:this.productId
            }
            axios.get("/product/getById",{params:params}).then(res=>{
                this.productName=res.data.productName;
                this.stockQuantity=res.data.stockQuantity;
                this.discount=res.data.discount;
                this.price=res.data.price;
                this.otherPicUrls=res.data.otherPicUrls;
                this.mainPicUrl=res.data.mainPicUrl;
                console.log(this.product);
            })
        },
        currentchange(pageNum){
            this.pageNum=pageNum;
            this.search();
        }
        
    },mounted() {
        var url = new URL(location.href);
        this.productId = url.searchParams.get("productId");
        console.log(this.productId)
        this.getProduct();
    },
})