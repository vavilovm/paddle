package io.paddle.plugin.python

import io.paddle.plugin.Plugin
import io.paddle.plugin.python.tasks.env.CleanTask
import io.paddle.plugin.python.tasks.env.VenvTask
import io.paddle.plugin.python.tasks.linter.MyPyTask
import io.paddle.plugin.python.tasks.linter.PyLintTask
import io.paddle.plugin.python.tasks.tests.PyTestTask
import io.paddle.project.*
import io.paddle.tasks.Task

object PythonPlugin : Plugin {
    override fun tasks(project: Project): List<Task> {
        return listOf(
            CleanTask(project),
            VenvTask(project)
        ) + listOf(
            MyPyTask(project),
            PyLintTask(project),
            PyTestTask(project)
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun extensions(project: Project): List<Project.Extension<Any>> {
        return listOf(
            EnvironmentExtension,
            RequirementsExtension
        ) as List<Project.Extension<Any>>
    }
}
