# TeamCity UI Plugin development demo

This repository describes the way to develop plugins. 

There are some useful resources for this repository:
* [JetBrains / TeamCity Blog post about the UI Plugins](https://blog.jetbrains.com/teamcity/2020/09/teamcity-2020-2-updated-plugin-development)
* [JetBrains / TeamCity UI Plugin Development Documentation](https://plugins.jetbrains.com/docs/teamcity/front-end-extensions.html)

## Prerequisites

#### Backend Part:
To get started writing a plugin for TeamCity, set up the plugin development environment.

Download and install OpenJDK 8 (e.g. by [AdoptOpenJDK](https://adoptopenjdk.net/)). Set the [JAVA_HOME](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/index.html) environment variable on your system. Java 1.8 is required, the 32-bit versionis recommended, the 64-bit version [can be used](https://www.jetbrains.com/help/teamcity/installing-and-configuring-the-teamcity-server.html).

Download and install [TeamCity](https://www.jetbrains.com/teamcity/download/) on your development machine. Since you are going to use this machine to test your plugin, it is recommended that this TeamCity server is of the same version as your production server. We are using TeamCity 10 installed on Windows in our setup.

Download and install a Java IDE; we are using [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download/), which has a built-in Maven integration.

Download and install [Apache Maven](https://maven.apache.org/download.cgi). Maven 3.2.x is recommended. Set the M2_HOME environment variable. Run mvn -version to verify your setup. We are using Maven 3.2.5. in our setup.

*All those steps also described in [Main Plugin Guide](https://plugins.jetbrains.com/docs/teamcity/getting-started-with-plugin-development.html)

#### Frontend Part (Controlled- and React-plugins):
We recommend you to use the Docker image to build the frontend part. 

To build a plugin, use

`docker-compose run build`

In this case, Docker container will generate a bundle.js and put it to the directory /demoPlugins-server/src/main/resources/buildServerResources. From there you can build a plugin and add it to the TeamCity instance.

To run a plugin using the Webpack Development server mode, use

`docker-compose run --service-ports dev`

In this case, the Webpack Server starts in the Docker container. By default, the Webpack Server starts on a port 8080. You can specify BUNDLE_DEV_URL as a http://localhost:8080 and use incrementally updated JavaScript file directly from the Webpack server.

## Basic, Controlled, React plugins. What are they about?

To put it simple, using different types of plugins you make the UI handle the plugin updates differently. In case of Basic plugin - the content reloads and changes every time you navigate in the App. Using controlled version you decide, whether plugin should reload content or not. The React plugin - is the extended Controlled plugin, which allows you to reuse Components, written by JetBrains team (Sakura UI components, Ring UI). 

## Feedback, feature-requests and bug-reports

There is a dedicated tag in YouTrack: [SakuraUI-plugin](https://youtrack.jetbrains.com/issues/TW?q=%23SakuraUI-Plugins%20). Using the Fix Version property you can filter the tasks, which are going to be released in the next Major / Minor version of TeamCity.
 
Feel free to write us a line, if you have any complaints about the Plugin. 

Wish you a happy coding!
