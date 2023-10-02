package com.github.fanlun007.helloideaplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class HelloAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        // TODO: insert action logic here

        println(e.project)

        Messages.showInfoMessage("Hello World Content", "Hello World Title")
    }
}
