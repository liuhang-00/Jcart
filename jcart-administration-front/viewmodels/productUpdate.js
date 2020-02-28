var app = new Vue({
    el: '#app',
    data: {
        selectedMainPic: '',
        mainPicUrl: '',
        selectedOtherPics: [],
        otherPicUrls: [],
        productId:0,
        productVo:{},
        statusList:[
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ],
        mainFileList: [],
        otherFileList: []
    },methods: {
        getProduct(){
            var params={
                productId:this.productId
            }
            axios.get("/product/getById",{params:params}).then(res=>{
                console.log(res.data);
                this.productVo.productName=res.data.productName;
                this.productVo.productCode=res.data.productCode;
                this.productVo.productId=res.data.productId;
                this.productVo.stockQuantity=res.data.stockQuantity;
                this.productVo.status=res.data.status;
                this.productVo.price=res.data.price;
                this.productVo.discount=res.data.discount;
                this.productVo.rewordPoints=res.data.rewordPoints;
                this.productVo.description=res.data.description;
                this.mainPicUrl=res.data.mainPicUrl;
                this.otherPicUrls=res.data.otherPicUrls;
                this.productVo.sortOrder=res.data.sortOrder;
                
            })
        },
        onsubmit(){
            console.log(this.productVo);
            axios.post("/product/update",{
                productCode:this.productVo.productCode,
                productName:this.productVo.productName,
                status:this.productVo.status,
                price:this.productVo.price,
                discount:this.productVo.discount,
                stockQuantity:this.productVo.stockQuantity,
                mainPicUrl:this.mainPicUrl,
                rewordPoints:this.productVo.rewordPoints,
                sortOrder:this.productVo.sortOrder,
                description:this.productVo.description,
                otherPicUrls:this.otherPicUrls
            }).then(function (response) {
                console.log(response);
                alert('修改成功');
            })
            .catch(function (error) {
                console.log(error);
                alert('修改失败');
            });
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        handleUploadMainClick() {
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.mainPicUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        handleOnOtherChange(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleOnOtherRemove(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleUploadOtherClick() {
            console.log('upload other pic click');
            this.uploadOtherImage();
        },
        uploadOtherImage() {
            this.selectedOtherPics.forEach(pic => {
                var formData = new FormData();
                formData.append("image", pic.raw);

                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        var url = response.data;
                        app.otherPicUrls.push(url);
                        alert('上传成功');
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
            });


        },

    },mounted() {
        var url = new URL(location.href);
        this.productId = url.searchParams.get("productId");
        console.log(this.productId)
        this.getProduct();
    },
})