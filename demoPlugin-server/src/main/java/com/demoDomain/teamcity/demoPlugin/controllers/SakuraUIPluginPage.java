package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.users.SUser;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import jetbrains.buildServer.web.openapi.buildType.BuildTypeTab;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class SakuraUIPluginPage extends BuildTypeTab {
    public SakuraUIPluginPage(
            @NotNull WebControllerManager manager,
            @NotNull ProjectManager projectManager,
            @NotNull PluginDescriptor descriptor) {
        super("Sakura", "Sakura Related Tab", manager, projectManager, descriptor.getPluginResourcesPath("basic-plugin.jsp"));
        addJsFile(descriptor.getPluginResourcesPath("/js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("/css/styles.css"));
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        return true;
    }

    @Override
    protected void fillModel(@NotNull Map<String, Object> model, @NotNull HttpServletRequest httpServletRequest, @NotNull SBuildType sBuildType, @Nullable SUser sUser) {
        model.put("buildType", sBuildType);
    }
}
