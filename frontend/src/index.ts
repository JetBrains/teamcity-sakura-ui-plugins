import Plugin from "@jetbrains/teamcity-api/plugin"
import App from './App/App'
import AllBuilds from "./AllBuilds/AllBuilds";

// @ts-ignore
new Plugin([Plugin.placeIds.SAKURA_SIDEBAR_TOP, Plugin.placeIds.BEFORE_CONTENT], {
    name: "Sakura UI Plugin",
    content: App,
});
