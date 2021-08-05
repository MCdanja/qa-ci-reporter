package com.tkormachev.kotlin.gradle.test.reporting.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

const val TASK_NAME_TESTRAIL = "publishToTestRail"
const val TASK_NAME_ALLURE = "publishToAllure"

abstract class ReportingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME_TESTRAIL, ReportToTestRailTask::class.java) {}
        project.tasks.register(TASK_NAME_ALLURE, ReportToAllureServerTask::class.java) {}
    }
}
