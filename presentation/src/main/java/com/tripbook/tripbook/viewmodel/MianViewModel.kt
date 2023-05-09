package com.tripbook.tripbook.viewmodel

import com.tripbook.tripbook.utils.NetWorkManger

class MianViewModel (private val netWorkManger: NetWorkManger) {

    private fun chkNetWork() : Boolean {
        return netWorkManger.chkNetWork()
    }
}