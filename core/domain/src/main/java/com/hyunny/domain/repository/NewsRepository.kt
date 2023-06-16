package com.hyunny.domain.repository

import com.hyunny.model.Headlines
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getHeadlines(page: Int): Flow<Headlines>

}
