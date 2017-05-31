package com.d.yangc.framework.kotlin.single


/**
 * Created by yangc on 2017/5/31.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated: 单例模式 生对象更多的用途是用来创建一个单例类。
 * 如果只是简单的写，直接用伴生对象返回一个 val 修饰的外部类对象就可以了，
 * 但是更多的时候我们希望在类被调用的时候才去初始化他的对象。
 * 以下代码将线程安全问题交给虚拟机在静态内部类加载时处理，是一种推荐的写法
 */
class UserSingle private constructor() {

    companion object {
        @JvmStatic //java 访问
        fun getInstance(): UserSingle {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = UserSingle()
    }


}