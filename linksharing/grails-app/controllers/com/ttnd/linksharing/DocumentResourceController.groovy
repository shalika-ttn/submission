package com.ttnd.linksharing

class DocumentResourceController {

    def index() { }

    def saveDoc(String filepath,String name, String description) {
        Topic topic = Topic.findByName(name)

        DocumentResource doc = new DocumentResource(createdBy: session.user, topic: topic, description: description, filepath: filepath)

        if(doc){
            if (doc.save(flush: true)) {
                flash.message = " document saved ------Success "
                render flash.message
                // render(view: 'save')
            } else {
                log.error(" Could not save document ${doc}")
                flash.message = "Document ${doc.properties} dosent satisfied constraints"
                render flash.message

            }}else render" error creating doc"


    }
}
