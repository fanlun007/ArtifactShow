package com.github.fanlun007.helloideaplugin.actions

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.popup.JBPopup
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.util.Key
import com.intellij.openapi.wm.impl.ExpandableComboAction
import com.intellij.openapi.wm.impl.ToolbarComboWidget
import com.intellij.ui.util.maximumWidth
import javax.swing.JComponent

class ProjectToolbarWidgetAction2 : ExpandableComboAction() {

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

    override fun updateCustomComponent(component: JComponent, presentation: Presentation) {
        val toolbarComboWidget = component as ToolbarComboWidget
        toolbarComboWidget.text = presentation.text
    }

    override fun createPopup(event: AnActionEvent): JBPopup {
        val group = ActionManager.getInstance().getAction("MainToolbarArtifactGroup") as ActionGroup

        return JBPopupFactory.getInstance()
            .createActionGroupPopup(null, group, event.dataContext, JBPopupFactory.ActionSelectionAid.NUMBERING, false, "what this")
    }

    override fun update(e: AnActionEvent) {

        val project = e.project
        val projectName = project?.name ?: ""
        e.presentation.setText(projectName, false)
        e.presentation.description = projectName

    }
}