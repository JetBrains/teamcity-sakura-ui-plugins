import Plugin from "@teamcity/react-api/plugin"
import App from './App/App'
import AllBuilds from "./AllBuilds/AllBuilds";

new Plugin(Plugin.placeIds.SAKURA_SIDEBAR_TOP, {
    name: "Sakura UI Plugin",
    content: App,
})

new Plugin(Plugin.placeIds.SAKURA_PROJECT_BEFORE_CONTENT, {
    name: "Sakura UI Plugin",
    content: AllBuilds,
})

