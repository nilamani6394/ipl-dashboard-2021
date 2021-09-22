package com.nilmani.ipldashboard2021.model

import com.nilmani.ipldashboard2021.entity.Team
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.Consumer
import javax.persistence.EntityManager
import javax.transaction.Transactional


@Component
class JobCompletionNotificationListener : JobExecutionListenerSupport() {

    private val log: Logger = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
  @Autowired
  private lateinit var entityManager: EntityManager

    @Autowired
    fun JobCompletionNotificationListener(em: EntityManager) {
        entityManager = entityManager
    }

    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status === BatchStatus.COMPLETED){
            log.info("!!! JOB FINISHED! Time to verify the results")
            val teamDate : Map<String,Team> = HashMap()
            entityManager?.createQuery("select m.team1, count(*) from Match m group by m.team1", Array<Any>::class.java)
        }
    }

//    @Transactional
//    override fun afterJob(jobExecution: JobExecution) {
//        if (jobExecution.getStatus() === BatchStatus.COMPLETED) {
//            log.info("!!! JOB FINISHED! Time to verify the results")
//            val teamData: MutableMap<String, Team> = HashMap()
//            em!!.createQuery(
//                "select m.team1, count(*) from Match m group by m.team1",
//                Array<Any>::class.java
//            )
//                .resultList
//                .stream()
//                .map { e: Array<Any> ->
//                    Team(
//                        e[0] as String, e[1] as Long
//                    )
//                }
//                .forEach { team: Team -> teamData[team.teamName.toString()] = team }
//            em!!.createQuery(
//                "select m.team2, count(*) from Match m group by m.team2",
//                Array<Any>::class.java
//            )
//                .resultList
//                .stream()
//                .forEach { e: Array<Any> ->
//                    val team = teamData[e[0] as String]
//                    team?.totalMatches = team!!.totalMatches + e[1] as Long
//                }
//            em!!.createQuery(
//                "select m.matchWinner, count(*) from Match m group by m.matchWinner",
//                Array<Any>::class.java
//            )
//                .resultList
//                .stream()
//                .forEach { e: Array<Any> ->
//                    val team = teamData[e[0] as String]
//                    team?.wins = e[1] as Long//.setTotalWins(e[1] as Long)
//                }
//            teamData.values.forEach(Consumer { team: Team? -> em!!.persist(team) })
//            teamData.values.forEach(Consumer { team: Team? -> println(team) })
//        }
//    }

}

