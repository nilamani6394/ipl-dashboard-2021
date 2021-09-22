package com.nilmani.ipldashboard2021.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class Match(
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,
    var city: String = "",
    var date: LocalDateTime = LocalDateTime.now(),
    var player_of_match: String = "",
    var venue: String = "",
    val neutral_venue:String="",
    var team1: String = "",
    var team2: String = "",
    var toss_winner: String = "",
    var toss_decision: String = "",
    var winner: String = "",
    var result: String = "",
    var result_margin: String = "",
    val method:String="",
    var umpire1: String = "",
    var umpire2: String = "",
)

