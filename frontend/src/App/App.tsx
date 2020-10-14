import {H2} from '@jetbrains/ring-ui/components/heading/heading'
import {React} from "@jetbrains/teamcity-api"
import type {PluginContext} from "@jetbrains/teamcity-api"
import Icon from '@jetbrains/ring-ui/components/icon/icon'

import Linux from './os-linux.svg'
import styles from './App.css'

type ProfileInfoProps = {
    onNameClick: () => void
    name: string
}
const ProfileInfo = React.memo<ProfileInfoProps>(
  ({onNameClick, name}: ProfileInfoProps) =>
    <H2 className={styles.name} onClick={onNameClick}>
        {`Hello, ${name}`}
        <Icon glyph={Linux} />
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
            <ProfileInfo onNameClick={toggleExpanded} name={defaultProfile.name} />
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
