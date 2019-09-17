package com.stavros.readwriteexcel.model

import java.net.Inet4Address

class CustomerModel {
    var id: String? = null
    var name: String? = null
    var address : String? = null
    var age : Int? = 0

    constructor()

    constructor(id:String? , name: String? , address: String? , age: Int?){
        this.id = id
        this.name = name
        this.address = address
        this.age = age

    }

    override fun toString(): String {
        return "Customer(id=$id, name=$name, address=$address, age=$age)"
    }


}