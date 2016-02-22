package com.ttnd.linksharing

class ResourceController {

    def index() {}

    def delete(long id) {
        Resource resource = Resource.load(id)


        if (resource)
            try {
                resource.delete()
            } catch (Exception e) {
                render "$e resource could not be found hence could not be deleted"
            }

    }
}
