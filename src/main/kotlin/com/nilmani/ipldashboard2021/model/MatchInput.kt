package com.nilmani.ipldashboard2021.model

data class MatchInput(
    val id: String="",
    val city:String="",
    val date:String="",
    val player_of_match:String="",
    val venue:String="",
    val neutral_venue:String="",
    val team1:String="",
    val team2:String="",
    val toss_winner:String="",
    val toss_decision:String="",
    val winner:String="",
    val result:String="",
    val result_margin:String="",
    val eliminator:String="",
    val method:String="",
    val umpire1:String="",
    val umpire2:String=""

)
