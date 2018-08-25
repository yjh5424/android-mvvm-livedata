package com.example.yunjunghyeon.demoapp_mvvm.domain.model



data class Response<T>(
        var status: Status,
        var data : T?,
        var throwable: Throwable?
){

        fun loading() {
                status = Status.LOADING
                this.data=null
                throwable=null
        }

        fun scuucess(data : T) {
                status=Status.SUCCESS
                this.data=data
                throwable=null
        }

        fun error(throwable: Throwable) ={
                status=Status.ERROR
                this.data=null
                this.throwable=throwable
        }
}