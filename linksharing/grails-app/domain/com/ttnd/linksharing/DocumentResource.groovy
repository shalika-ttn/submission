package com.ttnd.linksharing

class DocumentResource extends Resource {
    String filepath


//    static transients = ['contentType']
    static constraints = {
        filepath(nullable: false, blank: false)
//
//        contentType( bindable: true,validator: {val ,obj ->
//
//             if(obj)
//             {
//                 val.endsWith(DOCUMENT_CONTENT_TYPE)
//             }
//      })
    }


    String toString() {
        "this is document resource path: $filepath"
    }
}
