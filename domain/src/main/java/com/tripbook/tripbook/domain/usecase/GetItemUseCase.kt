package com.tripbook.tripbook.domain.usecase

import com.tripbook.tripbook.domain.model.Item
import com.tripbook.tripbook.domain.repository.ItemRepository

class GetItemUseCase(private val itemRepository: ItemRepository) {

    fun execute() : List<Item> {
        return itemRepository.getItem()
    }
}