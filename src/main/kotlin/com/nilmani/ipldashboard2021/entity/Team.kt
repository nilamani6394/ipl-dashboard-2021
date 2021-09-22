package com.nilmani.ipldashboard2021.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient

@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long =-1,
    val teamName: String ="",
    var totalMatches:Long=-1,
    var wins:Long=-1,
    @Transient
    var matches:List<Match> = ArrayList()
)
//https://github.com/koushikkothagal/ipl-dashboard/blob/master/src/main/java/io/javabrains/ipldashboard/model/Team.java
