package com.nilmani.ipldashboard2021.repository

import com.nilmani.ipldashboard2021.entity.Match
import com.nilmani.ipldashboard2021.entity.Team
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<Team,Long> {
    fun findByTeamName(teamName:String):Team
}
