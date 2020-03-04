var app = new Vue({
    el: '#app',
    data: {
        administrator:[],
        total:0,
        pageSize:2,
        pageNum:1,
        selectedAdministrators: []

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
        } ,handleDelete(index, row) {
            console.log('delete click');

            if (confirm("确认删除？")) {
                this.deleteAdministrator(row.administratorId);
            }
        },
        handleBatchDeleteClick() {
            console.log('batch delete click');
            if (confirm("确认删除？")) {
                this.batchDeleteAdministrators();
            }
        },
        handleSelectionChange(val) {
            console.log('selection change', val);
            this.selectedAdministrators = val;
        },
        deleteAdministrator(administratorId) {
            axios.post('/administrator/delete', administratorId, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('删除成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        batchDeleteAdministrators() {
            axios.post('/administrator/batchDelete', this.selectedAdministratorIds)
                .then(function (response) {
                    console.log(response);
                    alert('批删成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },mounted() {
        this.getList();
    },
})