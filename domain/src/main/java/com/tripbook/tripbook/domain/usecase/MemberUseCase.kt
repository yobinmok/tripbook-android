package com.tripbook.tripbook.domain.usecase

import com.tripbook.tripbook.domain.model.MemberInfo
import com.tripbook.tripbook.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemberUseCase  @Inject constructor(
    private val repository: MemberRepository
) {
    operator fun invoke() : Flow<MemberInfo?> = repository.getMember()

}