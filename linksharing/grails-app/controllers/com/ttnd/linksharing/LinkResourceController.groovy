package com.ttnd.linksharing

class LinkResourceController {

    def index() { }

    def saveLink(String url,int name, String description) {
        Topic topic = Topic.findById(name)
        LinkResource link = new LinkResource(url: url, description:description, createdBy:session.user, topic:topic)


        if(link){
            if (link.save(flush: true)) {
                flash.message = " Link saved ------Success "
                render flash.message
                // render(view: 'save')
            } else {
                log.error(" Could not save document ${link}")
                flash.message = "Link ${link.properties} dosent satisfied constraints"
                render flash.message


            }}else render" error creating link"


    }


}
