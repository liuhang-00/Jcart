var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:''
    },methods: {
        handleLoginClick(){
            console.log("login click");
            this.loginAdministrator();
        },
        loginAdministrator(){
            var params={
                username:this.username,
                password:this.password
            }
            axios.get('/administrator/login',{
                params:params
            }).then(res=>{
                console.log(res);
                var dto = res.data;
                localStorage['jcartToken']= dto.token;
                localStorage['expireTimestamp']= dto.expireTimestamp;
                alert('登陆成功');
            }).catch(res=>{
                console.log(res);
            })
        }
    },mounted() {
        
    },
})