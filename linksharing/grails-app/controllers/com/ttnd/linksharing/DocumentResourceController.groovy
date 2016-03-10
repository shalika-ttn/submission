package com.ttnd.linksharing

import com.ttnd.linksharing.CO.documentResourceCo
import grails.transaction.Transactional
import org.h2.schema.Constant
import org.springframework.web.multipart.MultipartFile
import com.ttnd.linksharing.Constants.Constant


class DocumentResourceController extends ResourceController {

    def index() {}

    @Transactional
    def saveDoc(documentResourceCo documentResourceCo) {
        String filepath = new File("${grailsApplication.config.linksharing.documents.folderPath}/${documentResourceCo.name}.pdf")


        Topic topic = Topic.findById(documentResourceCo.id)

        DocumentResource doc = new DocumentResource(createdBy: session.user, topic: topic, description: documentResourceCo.description, filepath: filepath,
                contentType: documentResourceCo.contentType)


        if (doc.validate()) {
            println("........${documentResourceCo.myFile}")
            File file = new File(filepath) << documentResourceCo.myFile.bytes
            println("........${file.size()}")
            if (doc.save(flush: true)) {
                flash.message = " document saved ------Success "
                render flash.message
                readingItem(doc)
            } else {
                log.error(" Could not save document ${doc}")
                flash.message = "Document ${doc.properties} dosent satisfied constraints"
                render flash.message

            }
        } else render " error creating doc"


    }


    private  def readingItem(DocumentResource resource) {
        Topic topic = resource.topic

        List<User> user = topic.getsubscribedUser()

        user.each {
            ReadingItem readingItem
            if (it == session.user)
                readingItem = new ReadingItem(resource: resource, user: it, isRead: true)
            else
                readingItem = new ReadingItem(resource: resource, user: it, isRead: false)

            it.addToReadingItems(readingItem)
        }
    }


    def download(Long id) {
        DocumentResource resource = DocumentResource.findById(id)
        if (resource) {
            Topic topic = resource.topic
            if (topic.canViewBy(session.user.id)) {
                File file1 = new File(resource.filepath)
                response.setHeader("Content-disposition", "attachment; filename=" + resource.fileName)
                response.contentType = Constant.DOCUMENT_CONTENT_TYPE
                response.contentLength = file1.bytes.length
                response.outputStream << file1.bytes
            } else {
                render "resource is not accessible by logged in user"
            }
        } else
            render "resource not found"

    }
}