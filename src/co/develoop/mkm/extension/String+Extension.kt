package co.develoop.mkm.extension

import java.net.URLEncoder

fun String.utf8(): String =
        URLEncoder.encode(this, "UTF-8")