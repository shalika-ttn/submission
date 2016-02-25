package com.ttnd.linksharing

class ResourceRating {


    Integer score
    static belongsTo = [user: User, resource: Resource]


    static constraints = {

        score(nullable: false, min: 1, max: 5)
        resource(unique: 'user', nullable: false)
    }

    static  List showTopPost() {
        List result = ResourceRating.createCriteria().list() {

            projections {
                groupProperty('resource.id')
                count('score', 'res')
            }
            order('res',"desc")
            maxResults 5



        }
     result

    }
}
