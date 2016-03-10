package com.ttnd.linksharing

import com.ttnd.linksharing.Constants.Constant

class DocumentResource extends Resource {
    String filepath
    String contentType
    String fileName
    static transients = ['contentType', 'fileName']
    static constraints = {
        filepath(nullable: false, blank: false)
        contentType(bindable: true,nullable: true, validator: { val, obj ->

            if (val != Constant.DOCUMENT_CONTENT_TYPE)
                false
                //"com.ttnd.linksharing.Resource.contentType.validator"
                 else   true
        })
        fileName(bindable:true,nullable: true)
    }

    String getFileName() {
        List arrayFilePath = filepath.split("/")
        arrayFilePath.last()

    }

    void setContentType(String cType) {
        contentType = cType
    }

    String getContentType() {
        this.contentType
    }

    String toString() {
        "this is document resource path: $filepath"
    }
}
