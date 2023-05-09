package com.tripbook.tripbook.domain.repository

import com.tripbook.tripbook.domain.model.Item

interface ItemRepository {
    fun getItem() : List<Item>
}