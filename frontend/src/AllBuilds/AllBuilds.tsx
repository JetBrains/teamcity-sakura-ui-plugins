import Loader from '@jetbrains/ring-ui/components/loader/loader'
import {H1} from '@jetbrains/ring-ui/components/heading/heading'
import {Content}  from '@jetbrains/ring-ui/components/island/island'
import React from '@jetbrains/teamcity-api/react'
import TCComponents from '@jetbrains/teamcity-api/components'

const AllBuilds = () => {
    const [count, setCount] = React.useState(3);

    React.useEffect(() => {
        if (count > 0) {
            setTimeout(() => setCount(count => count - 1), 1000)
        }
    }, [count])

    return <Content>
        {count === 0
          ? <TCComponents.AllBuilds />
          : (
            <div>
                <Loader />
                <H1>{`The React Plugin content will be shown in ${count} second`}</H1>
            </div>
          )
        }
    </Content>
};

export default React.memo(AllBuilds)
