package com.omarea.krscript.model

open class ConfigItemBase {
    // 分组标题
    var separator: String = ""
    // 标题
    var title: String = ""
    // 描述
    var desc: String = ""
    // 是否在开始前显示操作确认提示
    var confirm: Boolean = false
    // 执行完成后是否自动关闭界面
    var autoOff: Boolean = false
    // 是否可中断执行
    var interruptible: Boolean = false
}