var app = new Vue({
    el: '#app',
    data: {
        administrator:[],
        total:0,
        pageSize:2,
        pageNum:1
    },methods: {
        currentchange(pageNum){
            this.pageNum=pageNum;
            this.getList();
        },
        getList(){
            var params={
                pageNum:this.pageNum
            };
            axios.get("/administrator/getList",{
                params:params
            }).then(res=>{
                console.log(res.data);
                this.administrator=res.data.list;
                this.total=res.data.total;
                this.pageNum=res.data.pageNum;
                this.pageSize=res.data.pageSize;
            })
        },
        handleDelete(index,row){

        },
        handleSelectionChange(){

        },
        handleBatchDeleteClick(){

        }
    },mounted() {
        this.getList();
    },
})