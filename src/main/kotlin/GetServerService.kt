package com.dakuo.arma3bot


import org.jsoup.Jsoup

object GetServerService {
    fun getServerPlayersList(): String {
        var result: String = ""
        val connect = Jsoup.connect("https://www.battlemetrics.com/servers/arma3/${config.serverId}")
        val document = connect.get()

        val playerCountDocuments = document.getElementsByClass("css-1i1egz4")
        val dd = playerCountDocuments.first()?.getElementsByTag("dd")?.get(1)
        val split = dd?.text()?.split("/")
        val nowPlayerCount = split?.get(0)
        val maxPlayerCount = split?.get(1)
        result += ("当前在线人数: $nowPlayerCount/$maxPlayerCount \n")

        val playerListDocuments = document.getElementsByClass("css-zwebxb")
        playerListDocuments.forEach { element ->
            if (playerListDocuments.last() == element) {
                result += (element.text() + "\n")
            } else {
                result += (element.text() + ", ")
            }

        }
        return result;
    }
}