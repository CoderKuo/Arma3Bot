package com.dakuo.arma3bot

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent

object Arma3Bot : KotlinPlugin(
    JvmPluginDescription(
        id = "com.dakuo.Arma3Bot",
        name = "Arma3Bot",
        version = "1.0-SNAPSHOT",
    ) {
        author("dakuo")
    }
) {
    override fun onEnable() {
        config.reload()
        GlobalEventChannel.subscribeAlways<GroupMessageEvent>{event -> GroupMessageListener(event).monitor()}

//        logger.info { "Arma3 Bot加载成功" }
    }
}

object config : AutoSavePluginConfig("config"){
    val serverId by value("0")
}