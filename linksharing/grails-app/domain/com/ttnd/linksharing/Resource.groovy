package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visiblity
import com.ttnd.linksharing.VO.RatingInfoVo

abstract class Resource {
    String description
    User createdBy

    Date dateCreated
    Date lastUpdated
    String ratingInfo
    static transients = ['ratingInfo']
    static belongsTo = [topic: Topic]
    static hasMany = [resourcesRatings: ResourceRating, readingItems: ReadingItem]

    static mapping = {
        description(type: 'text')


    }

    static constraints = {
    }

    static namedQueries = {
        search { ResourceSearchCo co ->
            if (co.topicId) {
                //eq(co.topicId=id)

                topic {
                    eq('id', co.topicId)
                    eq('visiblity', co.visiblity)
                }
                // resources= Resource.findAllById(co.topicId)
            }
        }
    }


    RatingInfoVo getRatingInfo() {
        List result = ResourceRating.createCriteria().get() {
            'resource' {
                eq('id', this.id)
            }
            projections {
                sum('score')
                avg('score')
                count('score')


            }

        }
        RatingInfoVo ratingInfoVo = new RatingInfoVo(totalVotes: result[0], averageScore: result[1], totalScore: result[2])
        ratingInfoVo
    }


    static List<Resource> resourcePost() {
        List result1 = ResourceRating.showTopPost()
        List<Resource> resources = Resource.getAll(result1)

        resources
    }

    Boolean canViewByResource(Long id) {
        Resource resource = Resource.findById(id)

        if (resource.topic.canViewBy(topic.id))
            true
        else
            false
    }


    void deleteFile()
    {
        File file = new File(this.filepath)
        file.delete()
    }

    String toString() {
        "This $topic.name and description $description"
    }

}