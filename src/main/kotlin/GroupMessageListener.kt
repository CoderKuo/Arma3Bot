package com.dakuo.arma3bot


import com.dakuo.arma3bot.GetServerService.getServerPlayersList
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.message.data.toPlainText

class GroupMessageListener(private val event: GroupMessageEvent) {

    suspend fun monitor(){
        val plainText = getPlainText(event.message)
        val split = plainText.split(" ")
        if (split[0].equals("#查在线")){
            val serverPlayersList = GetServerService.getServerPlayersList()
            event.group.sendMessage(At(event.sender).plus("\n"+serverPlayersList))
            return
        }
    }

    fun getPlainText(str: MessageChain):String{
        val content = str.content.toPlainText();
        return if (content.equals("")) "" else content.contentToString().trim()
    }

}