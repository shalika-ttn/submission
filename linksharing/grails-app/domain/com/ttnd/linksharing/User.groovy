package com.ttnd.linksharing

import grails.util.Holders
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import com.ttnd.linksharing.CO.UserSearchCo
import com.ttnd.linksharing.Resource

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String username
    String password
    String firstName
    String lastName
    String email
    Byte[] photo
    Date dateCreated
    Date lastUpdated


    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static constraints = {


        email(unique: true, email: true, blank: false, nullable: false)

//		password(nullable: false, blank: false, minSize: 5)
        photo(nullable: true)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
//		userName(nullable: false, blank: false, unique: true)

//		confirmPassword bindable: true, nullable: true, blank: true, validator: { val, obj ->
//			//println "obj:${obj}******${val}"
//
//
//			if (val) {
//				if (obj.password != val) {
//					return false
//				}
//			}
//		}
        username blank: false, unique: true
        password blank: false

    }

    User(String username, String password) {
        this()
        this.username = username
        this.password = password
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    static namedQueries = {
        search { UserSearchCo userSearchCO ->
            eq('admin', false)
            if (userSearchCO.active != null) {
                eq("active", userSearchCO.active)
            }

            if (userSearchCO.q) {
                or {
                    ilike("firstName", "%${userSearchCO.q}%")
                    ilike("lastName", "%${userSearchCO.q}%")
                    ilike("email", "%${userSearchCO.q}%")
                    ilike("userName", "%${userSearchCO.q}%")

                }
            }
        }
    }


    String getName() {
        "$firstName $lastName"

    }

    List<Topic> getsubscribedTopics() {
        List<Topic> result = Subscription.createCriteria().list() {


            projections {
                property('topic')
            }


            eq('user.id', this.id)
        }

        result

    }

    Boolean canDeleteResource(Long resourceId) {
        Resource resource = Resource.findById(resourceId)

        if ((resource.createdBy == this) || this?.admin)
            true
        else
            false

    }

    Boolean isSubscribed(Long topicId) {
        Integer subscriptionsCount = Subscription.createCriteria().count() {
            eq('user', this)
            'topic' {
                eq('id', topicId)
            }
        }

        if (subscriptionsCount)
            true
        else
            false

    }

    Subscription getSubscription(Long id) {
        Topic topic = Topic.findById(id)
        Subscription subscription = Subscription.findByUserAndTopic(this, topic)
        subscription

    }

    Boolean equals(User user) {
        this.id == user.id
    }


    static Boolean updatePassword(String newPassword, String email) {

        if (User.executeUpdate("update User set password='${newPassword}' where email='$email'")) {
            println("===================inside if++++++++++++++++++++")
            true
        } else {
            false
        }
    }

    String toString() {
        "$firstName "
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService', 'subscribedTopics', 'name']

    static hasMany = [topics         : Topic, subscriptions: Subscription, resources: Resource, readingItems: ReadingItem,
                      resourceRatings: ResourceRating]

    static mapping = {
        password column: '`password`'
        photo(sqlType: 'longblob')

    }

    static User loggedInUser() {
        Holders.applicationContext.getBean('springSecurityService').getCurrentUser()
    }
}
