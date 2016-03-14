package com.ttnd.linksharing

import com.ttnd.linksharing.Constants.Constant

class DocumentResource extends Resource {
    String filepath
    String contentType
    String fileName
    static transients = ['contentType', 'fileName']
    static constraints = {
    }

    String getFileName() {
        contentType(bindable: true, nullable: true, validator: { val, obj ->
            if (!obj.id) {
                if (val != Constant.DOCUMENT_CONTENT_TYPE)
                    return 'com.ttnd.linksharing.Resource.contentType.validator'
            }
        })
        fileName(bindable: true, nullable: true)
        filepath(nullable: false, blank: false)
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
