package com.tripbook.tripbook.domain.usecase

import android.util.Log
import com.tripbook.tripbook.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    operator fun invoke(
        email: String

    ): Flow<Boolean> {
        Log.d("DeleteMemberUseCase", "invoke() called with email: $email")
        return memberRepository.deleteMember(email)
    }
}