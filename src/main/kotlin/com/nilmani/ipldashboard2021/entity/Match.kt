package com.nilmani.ipldashboard2021.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
@Entity
data class Match(
   @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=-1,
    val city:String="",
    val date:LocalDateTime= LocalDateTime.now(),
    val playerOfTheMatch:String="",
    val venue:String="",
    val team1:String="",
    val team2:String="",
    val tossWinner:String="",
    val tossDecision:String="",
    val  winnerTeam:String="",
    val result:String="",
    val resultMargin:String="",
    val umpire1:String="",
    val umpire2:String="",
    )
