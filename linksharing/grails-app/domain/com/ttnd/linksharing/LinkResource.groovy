package com.ttnd.linksharing

class LinkResource extends Resource {

    String url


    static constraints = {

        url(url: true)
    }
    String toString()
    {
        "hello this is linkresource with url: $url"
    }
}
