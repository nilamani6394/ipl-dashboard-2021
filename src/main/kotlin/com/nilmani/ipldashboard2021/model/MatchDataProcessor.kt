package com.nilmani.ipldashboard2021.model

import com.nilmani.ipldashboard2021.entity.Match
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor
import java.time.LocalDateTime


class MatchDataProcessor : ItemProcessor<MatchInput,Match> {
    val log: Logger = LoggerFactory.getLogger(MatchDataProcessor::class.java)

    @Throws(Exception::class)
    override fun process(matchInput: MatchInput): Match? {
        val match = Match()
        match.id = matchInput.id.toLong()
        match.city = matchInput.city
        match.date = LocalDateTime.parse(matchInput.date)
        match.player_of_match = matchInput.player_of_match
        match.venue = match.venue

        /** set innings order*/
        val firstInningsTeam:String
        val secondInningsTeam:String
        if ("bat" == matchInput.toss_decision){
            firstInningsTeam = matchInput.toss_winner
            secondInningsTeam =
                if (matchInput.toss_winner.equals(matchInput.team1))matchInput.team2
            else
                matchInput.team1
        }else{
            secondInningsTeam = matchInput.toss_winner
            firstInningsTeam =
                if (matchInput.toss_winner.equals(matchInput.team1))matchInput.team2
            else
                matchInput.team1
        }
        match.team1 = firstInningsTeam
        match.team2 = secondInningsTeam
        match.toss_winner = matchInput.toss_winner
        match.toss_decision = matchInput.toss_decision
        match.winner = matchInput.winner
        match.result = matchInput.result
        match.result_margin = matchInput.result_margin
        match.umpire1 = matchInput.umpire1
        match.umpire2 = matchInput.umpire2
        return  match
    }
}

