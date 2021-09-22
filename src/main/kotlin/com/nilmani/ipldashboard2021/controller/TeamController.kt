package com.nilmani.ipldashboard2021.controller

import antlr.collections.impl.LList
import com.nilmani.ipldashboard2021.entity.Match
import com.nilmani.ipldashboard2021.entity.Team
import com.nilmani.ipldashboard2021.repository.MatchRepository
import com.nilmani.ipldashboard2021.repository.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate


@RestController
class TeamController {
    @Autowired
    private lateinit var teamRepository: TeamRepository
    @Autowired
    private lateinit var matchRepository: MatchRepository

    @GetMapping("/team")
    fun  getAllTeam():Iterable<Team>{
        return teamRepository.findAll()
    }
    @GetMapping("/team/{teamName}")
    fun getTeam(@PathVariable teamName: String): Team? {
        val team: Team = this.teamRepository.findByTeamName(teamName)
        team.matches = matchRepository.findLatestMatchesbyTeam(teamName, 4)
        return team
    }

    fun getMatchesForTeam(@PathVariable teamName: String?,@RequestParam year: Int):List<Match>{
        val startDate = LocalDate.of(year,1,1)
        val endDate = LocalDate.of(year+1,1,1)
        return matchRepository.getMatchesByTeamBetweenDates(
            teamName,
            startDate,
            endDate
        )
    }
}

