package com.ttnd.linksharing

class DocumentResource extends Resource {
    String filepath
    static constraints = {
        filepath(nullable: false, blank: false)
    }

    String toString()
    {
        "this is $filepath"
    }
}
