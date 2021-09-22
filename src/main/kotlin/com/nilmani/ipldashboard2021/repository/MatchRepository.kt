package com.nilmani.ipldashboard2021.repository

import com.nilmani.ipldashboard2021.entity.Match
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDate


interface MatchRepository : CrudRepository<Match,Long> {
    fun getByTeam1OrTeam2OrderByDateDesc(teamName1: String?,teamName2: String?,pageable: Pageable):List<Match>

    @Query("SELECT m FROM Match m WHERE (m.team1 = :teamName OR m.team2 = :teamName) AND m.date BETWEEN :dateStart AND :dateEnd ORDER BY DATE(date) DESC ")
    fun getMatchesByTeamBetweenDates(
        @Param("teamName")teamName: String?,
        @Param("startDate")startDate: LocalDate?,
        @Param("endDate")endDate: LocalDate?): List<Match>

    fun findLatestMatchesbyTeam(teamName: String?, count: Int): List<Match> {
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count))
    }

}

