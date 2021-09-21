package com.nilmani.ipldashboard2021.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    val teamName:String="",
    val totalMatches:Long=-1,
    val wins:Long=-1,
)
//https://github.com/koushikkothagal/ipl-dashboard/blob/master/src/main/java/io/javabrains/ipldashboard/model/Team.java
