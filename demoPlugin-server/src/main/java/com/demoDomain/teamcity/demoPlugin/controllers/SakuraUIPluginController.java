package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SakuraUIPluginController extends BaseController {
    PluginDescriptor myDescriptor;
    WebControllerManager myController;

    public SakuraUIPluginController(
            @NotNull PluginDescriptor descriptor,
            WebControllerManager controllerManager,
            SBuildServer server
    ) {
        super(server);
        myDescriptor = descriptor;
        myController = controllerManager;

        myController.registerController("/lesnik.html", this);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView(myDescriptor.getPluginResourcesPath("basic-plugin.jsp"));
        return mv;
    }
}
