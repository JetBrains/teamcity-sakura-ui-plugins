package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.web.ContentSecurityPolicyConfig;
import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SakuraUIPluginController extends BaseController {
    private static final String PLUGIN_NAME = "SakuraUI-Plugin";

    private final PluginDescriptor myPluginDescriptor;

    public SakuraUIPluginController(
            @NotNull PluginDescriptor descriptor,
            @NotNull PagePlaces places,
            @NotNull WebControllerManager controllerManager
    ) {
        myPluginDescriptor = descriptor;

        String url = "/reactPlugin.html";
        final SimplePageExtension pageExtension = new SimplePageExtension(places);
        pageExtension.setPluginName(PLUGIN_NAME);
        pageExtension.setPlaceId(PlaceId.ALL_PAGES_FOOTER_PLUGIN_CONTAINER);
        pageExtension.setIncludeUrl(url);
        pageExtension.register();

        controllerManager.registerController(url, this);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws Exception {
        final ModelAndView mv = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("react-plugin.jsp"));
        mv.getModel().put("PLUGIN_NAME", PLUGIN_NAME);
        return mv;
    }
}



