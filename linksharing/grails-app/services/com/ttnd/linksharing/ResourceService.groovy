package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import grails.transaction.Transactional

@Transactional
class ResourceService {

    List<Resource> search(ResourceSearchCo resourceSearchCo) {

        Resource.resourceSearch(resourceSearchCo.getUser()).list()

    }
}

