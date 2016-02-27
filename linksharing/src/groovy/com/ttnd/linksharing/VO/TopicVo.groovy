package com.ttnd.linksharing.VO

import com.ttnd.linksharing.Enum.Visiblity
import com.ttnd.linksharing.User


class TopicVo {
    Integer id
    String name
    Visiblity visibility
    Integer count
    User createdBy
    String toString()
    {
        "topic with id $id  name $name "
    }
}
