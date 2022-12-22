package com.demoDomain.teamcity.demoPlugin.controllers;

import com.intellij.openapi.diagnostic.Logger;
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
    private static final Logger LOG = Logger.getInstance(SakuraUIPluginController.class.getName());


    public SakuraUIPluginController(
            @NotNull PluginDescriptor descriptor,
            WebControllerManager controllerManager,
            SBuildServer server
    ) {
        super(server);
        myDescriptor = descriptor;
        myController = controllerManager;

        myController.registerController(Constants.INCLUDE_URL, this);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView(myDescriptor.getPluginResourcesPath("tab-plugin.jsp"));
        PluginUIContext context = PluginUIContext.getFromRequest(httpServletRequest);

        LOG.warn("SAKURA DEMO PLUGIN CONTROLLER: " + context);

        // The token below is just a randomly generated string
        mv.getModel().put("token", "gasCs03bY2LjivX0lv0-cgolJO6qAZYxSWA6e1q");
        return mv;
    }
}
