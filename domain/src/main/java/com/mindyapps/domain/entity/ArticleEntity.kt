package com.mindyapps.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleEntity(
    val id: Int?,
    val author: String?,
    val title: String?,
    val content: String?
): Parcelable