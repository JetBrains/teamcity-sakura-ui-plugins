import {H2} from '@jetbrains/ring-ui/components/heading/heading'
import {React} from "@jetbrains/teamcity-api"
import type {PluginContext} from "@jetbrains/teamcity-api";

import styles from './App.css'

type ProfileInfoProps = {
    onToggleClick: () => void
    name: string
}
const ProfileInfo = React.memo<ProfileInfoProps>(
  ({onToggleClick, name}: ProfileInfoProps) =>
    <H2 className={styles.name}>
        {`Hello, ${name}`}
        <button onClick={onToggleClick}>{'Toggle'}</button>
    </H2>
)


const defaultProfile = {
    name: "Elvis",
}

function App({location}: {location: PluginContext}) {
    const [expanded, setExpanded] = React.useState(false)
    const toggleExpanded = React.useCallback(() => setExpanded(state => !state), [])

    return (
        <div className={styles.wrapper}>
            <ProfileInfo onToggleClick={toggleExpanded} name={defaultProfile.name} />
            {expanded && (
              <div>
                  {Object.entries(location).map(
                    ([key, value]) => value ? <p key={key}>{`${key}:${value}`}</p> : null
                  )}
              </div>
            )}
        </div>
    )
}

export default App
