package com.d.yangc.framework.kotlin.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by yangc on 2017/5/30.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
@Entity
class UserKotlinBean {

    @PrimaryKey
    private var id: Int = 0

    private var name: String? = null

    private var date:Date? =null
}